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

import cn.jinyahuan.commons.tester.report.Report;
import cn.jinyahuan.commons.tester.tc.TestCase;

import java.util.concurrent.Callable;

/**
 * todo 用于在线程池中执行。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public interface CallableTestCase extends Callable<Report>, TestCase {
    /**
     * 间接调用{@link TestCase#test() 测试用例的test}方法。
     *
     * @return
     * @throws Exception
     */
    @Override
    default Report call() throws Exception {
        return test();
    }
}
