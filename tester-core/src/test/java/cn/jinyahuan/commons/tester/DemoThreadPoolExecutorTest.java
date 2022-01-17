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

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class DemoThreadPoolExecutorTest {
    public static void main(String[] args) {
        DemoThreadPoolExecutor executor = new DemoThreadPoolExecutor(
                1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10240),
                new DemoThreadPoolExecutor.TesterThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.submit(new PassedCallableTestCase());
        executor.submit(new ExceptionCallableTestCase());
        executor.submit(new FailedCallableTestCase());

//        executor.shutdown();
    }
}