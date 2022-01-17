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
import cn.jinyahuan.commons.tester.report.DefaultReport;
import cn.jinyahuan.commons.tester.report.Report;
import cn.jinyahuan.commons.tester.report.ReportStatus;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class DemoThreadPoolExecutor extends ThreadPoolExecutor {
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

        // todo 收集信息，还有做一些检查：比如测试用例的编号是否重复等
        System.out.println("beforeExecute...");
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
            // todo 如果有异常 进行处理
            if (raw instanceof TestCaseException) {
                TestCaseException tce = (TestCaseException) raw;
                TestCase testCase = tce.getTestCase();
                System.out.println("出异常的测试用例：" + testCase);
            }
            e.printStackTrace();
        }

        if (report != null) {
            System.out.println("TestCase pass? " + DefaultReport.isPassed(report));
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
