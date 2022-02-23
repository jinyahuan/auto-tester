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

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class TestCaseReportInspectorTest {
    public static void main(String[] args) {
        TestCaseService tc1 = new TestCaseNoInspectorTest.DemoTestCaseService("1", null, null);
        TestCaseService tc2 = new TestCaseNoInspectorTest.DemoTestCaseService("2", null, null);
        TestCaseService tc3 = new TestCaseNoInspectorTest.DemoTestCaseService("3", null, null);

        tc1.setReport(DefaultReport.newPassed("成功", tc1.getTestCaseNo(), tc1));
        tc2.setReport(DefaultReport.newSkip("跳过", tc2.getTestCaseNo(), tc2));
        tc3.setReport(DefaultReport.newFailed("测试失败", tc3.getTestCaseNo(), tc3));

        ReportInspector inspector = new ReportInspector();
        inspector.collect(tc1);
//        inspector.collect(DefaultReport.newPassed("测试重复测试用例编号", tc1.getTestCaseNo(), tc1));
//        System.out.println(inspector.getReportByTestCaseNo("1"));

        inspector.collect(tc2);
        inspector.collect(tc3);

        System.out.println(inspector.getReportByTestCaseNo("3"));
    }

    static class DemoTestCaseService extends AbstractTestCaseService {
        public DemoTestCaseService(String testCaseNo, Requester requester, ResponseHandler responseHandler) {
            super(testCaseNo, requester, responseHandler);
        }
    }
}
