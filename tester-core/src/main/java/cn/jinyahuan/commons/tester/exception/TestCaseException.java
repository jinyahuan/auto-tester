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

package cn.jinyahuan.commons.tester.exception;

import cn.jinyahuan.commons.tester.TestCaseService;

/**
 * 所有与测试用例相关的异常的超类。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public abstract class TestCaseException extends RuntimeException {
    /**
     * 测试用例。
     */
    private TestCaseService testCase;

    // - - -

    public TestCaseException() {}

    public TestCaseException(String message, TestCaseService testCase) {
        super(message);
        this.testCase = testCase;
    }

    public TestCaseException(String message, Throwable cause, TestCaseService testCase) {
        super(message, cause);
        this.testCase = testCase;
    }

    public TestCaseException(Throwable cause, TestCaseService testCase) {
        super(cause);
        this.testCase = testCase;
    }

    // - - -

    public TestCaseService getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCaseService testCase) {
        this.testCase = testCase;
    }
}