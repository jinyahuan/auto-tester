/*
 * Copyright (c) 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.jinyahuan.commons.tester;

import cn.jinyahuan.commons.tester.exception.TestCaseException;
import cn.jinyahuan.commons.tester.exception.TestCaseNotPassException;
import cn.jinyahuan.commons.tester.report.Report;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class DemoThreadPoolExecutor extends ThreadPoolExecutor {
    private Inspector testCaseInspector = new TestCaseInspector();
    private Inspector reportInspector = new ReportInspector();

    public DemoThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                  long keepAliveTime, TimeUnit unit,
                                  BlockingQueue<Runnable> workQueue,
                                  ThreadFactory threadFactory,
                                  RejectedExecutionHandler handler)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);

        FutureTask<Report> ft = (FutureTask) r;

        // todo 收集信息，还有做一些检查：比如测试用例的编号是否重复等
        System.out.println("beforeExecute...");

        CallableTestCaseService action = getTestCaseFromFutureTask(ft);
        testCaseInspector.collect(action);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);

        // todo 主要是异常的处理
        System.out.println("afterExecute...");

        FutureTask<Report> ft = (FutureTask) r;
        Report report = null;
        try {
            report = ft.get();
        } catch (InterruptedException e) {
            // 正常情况下应该不会去中断线程
            throw new RuntimeException("Unknown exception", e);
        } catch (ExecutionException e) {
            Throwable raw = e.getCause();

            TestCaseException tce;
            if (raw instanceof TestCaseException) {
                tce = (TestCaseException) raw;
            }
            else {
                CallableTestCaseService action = getTestCaseFromFutureTask(ft);
                tce = new TestCaseNotPassException(e, action);
            }

            // todo 如果有异常进行处理，可能要利用阻塞队列来实现异常信息的报告
            TestCaseService testCase = tce.getTestCase();
            System.out.println("出异常的测试用例编号：" + testCase.getTestCaseNo());

            reportInspector.interrupt();
        }

        // 如果能正常拿到结果说明没有异常
        reportInspector.collect(report);
    }

    static CallableTestCaseService getTestCaseFromFutureTask(FutureTask<Report> ft) {
        Class<FutureTask> futureTaskClass = FutureTask.class;
        try {
            // todo 做缓存
            Field declaredField = futureTaskClass.getDeclaredField("callable");
            declaredField.setAccessible(true);

            return (CallableTestCaseService) declaredField.get(ft);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // todo 异常处理
            throw new RuntimeException(e);
        }
    }

    static class DemoUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            // todo 如果处理异常时发生了异常。。。
            System.out.println("uncaughtException..." + t.getName());
            e.printStackTrace();
        }
    }

    /**
     * copy from {@link java.util.concurrent.Executors.DefaultThreadFactory}.
     */
    static class TesterThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        TesterThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "tester-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            // 必须是非守护线程。否则线程都退出来了还怎么收集最终的测试结果
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            t.setUncaughtExceptionHandler(new DemoUncaughtExceptionHandler());
            return t;
        }
    }
}
