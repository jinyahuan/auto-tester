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

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class TestCaseNoInspectorTest {
    public static void main(String[] args) {
        TestCaseService tc1 = new DemoTestCaseService("1", null, null);
        TestCaseService tc2 = new DemoTestCaseService("2", null, null);
        TestCaseService tc3 = new DemoTestCaseService("3", null, null);

        TestCaseInspector inspector = new TestCaseInspector();
        inspector.collect(tc1);
        inspector.collect(tc2);
        inspector.collect(tc1);
        inspector.collect(tc3);

        System.out.println(inspector.getTestCaseByTestCaseNo("3"));
    }

    static class DemoTestCaseService extends AbstractTestCaseService {
        public DemoTestCaseService(String testCaseNo, Requester requester, ResponseHandler responseHandler) {
            super(testCaseNo, requester, responseHandler);
        }
    }
}
