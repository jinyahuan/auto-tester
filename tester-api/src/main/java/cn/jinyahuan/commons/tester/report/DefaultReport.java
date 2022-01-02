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
 * 默认的测试报告类。
 *
 * @author Yahuan Jin
 * @see Report
 * @see AbstractReport
 * @since 0.1
 */
public class DefaultReport extends AbstractReport implements Report {
    /**
     * 一个{@link DefaultReport}对象实例，其状态为通过的，并且为不可变对象。
     */
    public static final Report PASS = DefaultReport.newImmutableSuccessful();
    /**
     * 一个{@link DefaultReport}对象实例，其状态为不通过的，并且为不可变对象。
     */
    public static final Report FAIL = DefaultReport.newImmutableFailure();

    // - - -

    public DefaultReport() {}

    public DefaultReport(String testCaseNo, ReportStatus status, String msg) {
        super(testCaseNo, status, msg);
    }

    // - - -

    /**
     * 创建一个{@link DefaultReport}对象实例，其状态为通过的。
     *
     * @param testCaseNo 测试用例编号
     * @param msg        报告的摘要信息
     * @return 一个{@link DefaultReport}对象实例，其状态为通过的
     */
    public static Report newPassed(String testCaseNo, String msg) {
        return new DefaultReport(testCaseNo, DefaultReportStatus.PASS, msg);
    }

    /**
     * 创建一个{@link DefaultReport}对象实例，其状态为不通过的。
     *
     * @param testCaseNo 测试用例编号
     * @param msg        报告的摘要信息
     * @return 一个{@link DefaultReport}对象实例，其状态为不通过的
     */
    public static Report newFailed(String testCaseNo, String msg) {
        return new DefaultReport(testCaseNo, DefaultReportStatus.FAIL, msg);
    }

    /**
     * 检查{@code report}是否为通过测试的报告。
     *
     * @param report 待检测的报告实例
     * @return {@code true}，当且仅{@code report}为通过测试的报告
     * @see #nonPassed(Report)
     * @see ReportStatus#isPass()
     * @see ReportStatus#isPassed(ReportStatus)
     * @see ReportStatus#nonPassed(ReportStatus)
     */
    public static boolean isPassed(Report report) {
        return report != null && ReportStatus.isPassed(report.getStatus());
    }

    /**
     * 检查{@code report}是否不为通过测试的报告。
     *
     * @param report 待检测的报告实例
     * @return {@code true}，当且仅{@code report}不为通过测试的状态
     * @see #isPassed(Report)
     * @see ReportStatus#isPass()
     * @see ReportStatus#isPassed(ReportStatus)
     * @see ReportStatus#nonPassed(ReportStatus)
     */
    public static boolean nonPassed(Report report) {
        return !isPassed(report);
    }

    // - - -

    /**
     * 创建一个{@link DefaultReport}对象实例，其状态为通过的，并且为不可变对象。
     *
     * @return 一个 {@link DefaultReport}对象实例，其状态为通过的，并且为不可变对象
     */
    private static Report newImmutableSuccessful() {
        return new DefaultReport(null, DefaultReportStatus.PASS, "通过") {
            @Override
            public void setTestCaseNo(String testCaseNo) {
                return;
            }

            @Override
            public void setStatus(ReportStatus status) {
                return;
            }

            @Override
            public void setMsg(String msg) {
                return;
            }
        };
    }

    /**
     * 创建一个{@link DefaultReport}对象实例，其状态为不通过的，并且为不可变对象。
     *
     * @return 一个 {@link DefaultReport}对象实例，其状态为不通过的，并且为不可变对象
     */
    private static Report newImmutableFailure() {
        return new DefaultReport(null, DefaultReportStatus.FAIL, "失败") {
            @Override
            public void setTestCaseNo(String testCaseNo) {
                return;
            }

            @Override
            public void setStatus(ReportStatus status) {
                return;
            }

            @Override
            public void setMsg(String msg) {
                return;
            }
        };
    }
}