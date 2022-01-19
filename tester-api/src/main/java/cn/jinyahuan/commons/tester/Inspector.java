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

/**
 * todo 质检员助理。
 * <p>主要职责是 review {@link TestCase 测试用例}是否通过测试，同时决定是否中断整个测试。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public interface Inspector {
    /**
     * 收集测试用例的测试报告，并进行处理。
     *
     * @param report 待收集的测试用例的测试报告
     */
    void collect(Report report);

    /**
     * 中断整个测试，报告情况，然后退出虚拟机。
     */
    void interrupt();
}
