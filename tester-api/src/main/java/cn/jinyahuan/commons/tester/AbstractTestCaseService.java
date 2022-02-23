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

import cn.jinyahuan.commons.tester.report.Report;

/**
 * 测试用例服务的抽象类，方便快速实现一个测试用例服务类。
 * <p>骨架已经搭好了，只要赋值{@link #testCaseNo}、{@link #requester}、{@link #responseHandler}，
 * 然后执行{@link #test()}方法，如果没有发生非预期的情况，则会生成一份测试报告。
 * <pre>当前骨架的大致执行流程：
 *  1. {@link #requester}会请求指定的{@code API}，并且取得响应结果
 *  2. 拿到第1步取得的响应结果后，交由{@link #responseHandler}进行处理，生成一份测试报告
 * </pre>
 *
 * @param <R> {@code API}请求结果数据的类型
 * @param <T> 发送{@code API}请求的参数类型
 * @author Yahuan Jin
 * @see TestCase
 * @see TestCaseService
 * @see Requester
 * @see ResponseHandler
 * @see Report
 * @since 0.1
 */
public abstract class AbstractTestCaseService<R, T> implements TestCaseService<R, T> {
    /** 测试用例的编号 */
    protected String testCaseNo;
    /** 测试用例的{@code API}请求器 */
    protected Requester<R, T> requester;
    /** 测试用例的{@code API}请求器请求结果数据的处理器 */
    protected ResponseHandler<Report, R> responseHandler;
    /** 测试用例的测试报告 */
    protected Report report;
    /** 测试用例的启动测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差） */
    protected Long startTime;
    /** 测试用例的结束测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差） */
    protected Long endTime;

    // - - -

    public AbstractTestCaseService() {}

    public AbstractTestCaseService(String testCaseNo, Requester<R, T> requester,
                                   ResponseHandler<Report, R> responseHandler)
    {
        this.testCaseNo = testCaseNo;
        this.requester = requester;
        this.responseHandler = responseHandler;
    }

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
    public ResponseHandler<Report, R> getResponseHandler() {
        return responseHandler;
    }

    @Override
    public void setResponseHandler(ResponseHandler<Report, R> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public Report getReport() {
        return report;
    }

    @Override
    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public Long getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public Long getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public Report test() {
        Report result = null;

        setStartTime(System.currentTimeMillis());
        if (requester != null) {
            R response = requester.request();
            if (response != null) {
                responseHandler.setParam(response);
                result = responseHandler.handle();
                setReport(result);
            }
        }
        setEndTime(System.currentTimeMillis());

        return result;
    }
}
