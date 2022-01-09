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

package cn.jinyahuan.commons.tester.tc;

import cn.jinyahuan.commons.tester.report.Report;

/**
 * @param <R> {@code API}请求结果数据的类型
 * @param <T> 发送{@code API}请求的参数类型
 * @author Yahuan Jin
 * @see TestCase
 * @see NestedTestCase
 * @see TestCaseService
 * @see Report
 * @see Requester
 * @see ResponseHandler
 * @since 0.1
 */
public abstract class AbstractReportTestCaseService<R, T> extends AbstractTestCaseService<Report, R, T> {
    public AbstractReportTestCaseService() {}

    public AbstractReportTestCaseService(String testCaseNo, Requester<R, T> requester, ResponseHandler<Report, R> responseHandler) {
        super(testCaseNo, requester, responseHandler);
    }
}
