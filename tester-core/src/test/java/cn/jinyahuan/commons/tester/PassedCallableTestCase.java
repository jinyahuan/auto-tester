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
 * @author Yahuan Jin
 * @since 0.1
 */
public class PassedCallableTestCase extends AbstractTestCaseService
        implements CallableTestCaseService {
    public PassedCallableTestCase(String testCaseNo, Requester requester, ResponseHandler responseHandler) {
        super(testCaseNo, requester, responseHandler);
    }

    @Override
    public Report test() {
        Report report = DefaultReport.newPassed("成功", getTestCaseNo(), this);
        setReport(report);
        return report;
    }
}
