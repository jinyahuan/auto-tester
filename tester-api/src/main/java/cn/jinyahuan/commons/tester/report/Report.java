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

package cn.jinyahuan.commons.tester.report;

import cn.jinyahuan.commons.tester.tc.TestCase;

/**
 * 测试报告的超类接口。
 * <p>此类用于记录{@link TestCase 测试用例}的相关信息及其执行结果。
 *
 * @author Yahuan Jin
 * @see AbstractReport
 * @see DefaultReport
 * @since 0.1
 */
public interface Report {
    /**
     * 获取测试用例编号。
     *
     * @return 测试用例编号
     */
    String getTestCaseNo();

    /**
     * 设置测试用例编号。
     *
     * @param testCaseNo 测试用例编号
     */
    void setTestCaseNo(String testCaseNo);

    /**
     * 获取报告的状态。
     *
     * @return 报告的状态
     */
    ReportStatus getStatus();

    /**
     * 设置报告的状态
     *
     * @param status 报告的状态
     */
    void setStatus(ReportStatus status);

    /**
     * 获取报告的摘要信息。
     *
     * @return 报告的摘要信息
     */
    String getMsg();

    /**
     * 设置报告的摘要信息
     *
     * @param msg 报告的摘要信息
     */
    void setMsg(String msg);

    // todo TestCase 是否需要？？？
}
