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
public class TestCaseInspector extends AbstractInspector
        implements Inspector {

    @Override
    public void collect(TestCaseService tcs) {
        collectTestCase(tcs);
    }

    protected void collectTestCase(TestCaseService tcs) {
        final String testCaseNo = tcs.getTestCaseNo();
        TestCaseService old = testCases.putIfAbsent(testCaseNo, tcs);
        if (old != null) {
            // todo 应该打印日志并且调用链也尽量清晰
            System.out.println("测试用例编号重复啦" + ". testCaseNo=" + testCaseNo);

            interrupt();
        }
    }

    public TestCaseService getTestCaseByTestCaseNo(String testCaseNo) {
        return testCases.get(testCaseNo);
    }
}
