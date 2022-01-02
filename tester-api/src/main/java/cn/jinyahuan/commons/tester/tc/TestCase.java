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

package cn.jinyahuan.commons.tester.tc;

import cn.jinyahuan.commons.tester.report.Report;

/**
 * 测试用例的超类接口。
 *
 * @author Yahuan Jin
 * @see Requester
 * @see ResponseHandler
 * @see TestCaseGroup
 * @since 0.1
 */
public interface TestCase {
    /**
     * 对测试用例进行测试。
     *
     * @return 测试报告
     */
    Report test();

    /**
     * 获取测试用例的编号。
     *
     * @return 测试用例的编号
     */
    String getTestCaseNo();

    /**
     * 设置测试用例的编号。
     *
     * @param testCaseNo 测试用例的编号
     */
    void setTestCaseNo(String testCaseNo);

    // todo 请求参数以及结果处理器应该也是要需要获取及设置的
}