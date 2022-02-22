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
 * 标记测试用例未通过的异常。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public class TestCaseNotPassException extends TestCaseException {
    public TestCaseNotPassException() {}

    public TestCaseNotPassException(String message, TestCaseService testCase) {
        super(message, testCase);
    }

    public TestCaseNotPassException(String message, Throwable cause, TestCaseService testCase) {
        super(message, cause, testCase);
    }

    public TestCaseNotPassException(Throwable cause, TestCaseService testCase) {
        super(cause, testCase);
    }
}