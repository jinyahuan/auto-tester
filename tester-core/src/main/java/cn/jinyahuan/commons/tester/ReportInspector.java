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

import cn.jinyahuan.commons.tester.report.DefaultReport;
import cn.jinyahuan.commons.tester.report.Report;

/**
 * 测试报告的质检员。
 * <p>主要用于收集测试报告，同时检查测试报告是否通过测试。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public class ReportInspector extends AbstractInspector
        implements Inspector {

    @Override
    public void collect(TestCaseService tc) {
        collectReport(tc);
    }

    protected void collectReport(TestCaseService tc) {
        String testCaseNo = tc.getTestCaseNo();
        Report report = tc.getReport();

        if (DefaultReport.nonPassed(report)) {
            // todo 应该打印日志并且调用链也尽量清晰
            System.out.println("测试报告不通过" + ". testCaseNo=" + testCaseNo);

            interrupt();
        }

        Report old = reports.putIfAbsent(testCaseNo, report);
        if (old != null) {
            // todo 应该打印日志并且调用链也尽量清晰
            System.out.println("测试报告重复啦" + ". testCaseNo=" + testCaseNo);

            interrupt();
        }
    }

    public Report getReportByTestCaseNo(String testCaseNo) {
        return reports.get(testCaseNo);
    }
}
