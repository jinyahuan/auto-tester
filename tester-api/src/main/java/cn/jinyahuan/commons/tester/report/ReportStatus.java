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

/**
 * 测试报告状态的超类接口。
 * <p>此类用于标记{@link Report 报告}的状态，指示测试用例是否通过、不通过等等。
 *
 * @author Yahuan Jin
 * @see DefaultReportStatus
 * @see Report
 * @since 0.1
 */
public interface ReportStatus {
    /**
     * 获取测试报告的状态的状态值。
     *
     * @return 状态值
     */
    int getValue();

    /**
     * 获取测试报告的状态的状态描述。
     *
     * @return 状态描述
     */
    String getSummary();

    /**
     * 当前的状态是否为通过测试的状态。
     * <p>默认实现永远返回{@code false}。
     *
     * @return {@code true}，当且仅当前的状态为通过测试的状态
     * @see #isPassed(ReportStatus)
     * @see #nonPassed(ReportStatus)
     */
    default boolean isPass() {
        return false;
    }

    /**
     * 检查{@code status}是否为通过测试的状态。
     *
     * @param status 待检测的状态实例
     * @return {@code true}，当且仅{@code status}为通过测试的状态
     * @see #isPass()
     * @see #nonPassed(ReportStatus)
     */
    static boolean isPassed(ReportStatus status) {
        return status != null && status.isPass();
    }

    /**
     * 检查{@code status}是否不为通过测试的状态。
     *
     * @param status 检测的状态实例
     * @return {@code true}，当且仅{@code status}不为通过测试的状态
     * @see #isPass()
     * @see #isPassed(ReportStatus)
     */
    static boolean nonPassed(ReportStatus status) {
        return !isPassed(status);
    }
}
