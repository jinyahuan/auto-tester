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
 * 仿真的测试用例。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public class SimulationTestCase extends AbstractTestCaseService<String, String>
        implements CallableTestCaseService<String, String> {

    public SimulationTestCase() {}

    public SimulationTestCase(String testCaseNo, Requester requester, ResponseHandler responseHandler) {
        super(testCaseNo, requester, responseHandler);
    }

    // - - -

    public static class SimulationRequester extends AbstractRequester<String, String>
            implements Requester<String, String> {
        @Override
        String doRequest() {
            ApiHost apiHost = getApiHost();
            ApiPath apiPath = getApiPath();
            final String requestParam = getParam();
            final String requestUrl = apiHost.getHost() + apiPath.getPath();
            // 然后发送网络请求，并获得结果
            return "this is simulated response data";
        }
    }

    public class SimulationResponseHandler extends AbstractResponseHandler<Report, String>
            implements ResponseHandler<Report, String> {
        private TestCaseService testCase;

        public TestCaseService getTestCase() {
            return testCase;
        }

        public void setTestCase(TestCaseService testCase) {
            this.testCase = testCase;
        }

        public SimulationResponseHandler() {}

        public SimulationResponseHandler(TestCaseService testCase) {
            this.testCase = testCase;
        }

        @Override
        Report doHandle() {
            String param = getParam();
            // 根据 param 进行对应的处理
            Report report = DefaultReport.newPassed("成功", getTestCaseNo(), testCase);
            setReport(report);
            return report;
        }
    }

    public enum SimulationApiHost implements ApiHost {
        LOCAL("http://127.0.0.1",          "local", "本地环境", false),
        ;

        private final String host;
        private final String name;
        private final String summary;
        private final boolean isProductEnvironment;

        SimulationApiHost(String host, String name, String summary, boolean isProductEnvironment) {
            this.host = host;
            this.name = name;
            this.summary = summary;
            this.isProductEnvironment = isProductEnvironment;
        }

        @Override
        public String getHost() {
            return host;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getSummary() {
            return summary;
        }

        @Override
        public boolean isProductEnvironment() {
            return isProductEnvironment;
        }
    }

    public enum SimulationApiPath implements ApiPath {
        ACCOUNT_LOGIN("/acct/login", "账号登录", ""),
        ;

        private final String path;
        private final String title;
        private final String summary;

        SimulationApiPath(String path, String title, String summary) {
            this.path = path;
            this.title = title;
            this.summary = summary;
        }

        @Override
        public String getPath() {
            return path;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getSummary() {
            return summary;
        }
    }
}
