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
 * @param <P> 测试报告的类型
 * @param <R> {@code API}请求结果数据的类型
 * @param <T> 发送{@code API}请求的参数类型
 * @author Yahuan Jin
 * @see TestCase
 * @see Report
 * @see Requester
 * @see ResponseHandler
 * @see TestCaseGroup
 * @since 0.1
 */
public abstract class AbstractTestCase<P, R, T> implements TestCase<P, R, T> {
    /** 测试用例的编号 */
    protected String testCaseNo;
    /** 测试用例的{@code API}请求器 */
    protected Requester<R, T> requester;
    /** 测试用例的{@code API}请求器请求结果数据的处理器 */
    protected ResponseHandler<P, R> responseHandler;

    // - - -

    @Override
    public String getTestCaseNo() {
        return testCaseNo;
    }

    @Override
    public void setTestCaseNo(String testCaseNo) {
        this.testCaseNo = testCaseNo;
    }

    @Override
    public Requester<R, T> getRequester() {
        return requester;
    }

    @Override
    public void setRequester(Requester<R, T> requester) {
        this.requester = requester;
    }

    @Override
    public ResponseHandler<P, R> getResponseHandler() {
        return responseHandler;
    }

    @Override
    public void setResponseHandler(ResponseHandler<P, R> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public P test() {
        if (requester != null) {
            R response = requester.request();
            if (response != null) {
                return responseHandler.handle(response);
            }
        }
        return null;
    }
}