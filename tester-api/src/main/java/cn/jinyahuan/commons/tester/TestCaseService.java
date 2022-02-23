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
 * 测试用例服务类的的超类接口。
 * <p>提供测试用例相关的功能。
 *
 * @param <R> {@code API}请求结果数据的类型
 * @param <T> 发送{@code API}请求的参数类型
 * @author Yahuan Jin
 * @see TestCase
 * @see AbstractTestCaseService
 * @see Requester
 * @see ResponseHandler
 * @see Report
 * @since 0.1
 */
public interface TestCaseService<R, T> extends TestCase {
    /**
     * 获取测试用例的编号。
     *
     * @return 测试用例的编号
     */
    String getTestCaseNo();

    /**
     * 设置测试用例的编号。
     *
     * @param testCaseNo 测试用例的编号
     */
    void setTestCaseNo(String testCaseNo);

    /**
     * 获取测试用例的{@code API}请求器。
     *
     * @return 测试用例的{@code API}请求器
     */
    Requester<R, T> getRequester();

    /**
     * 设置测试用例的{@code API}请求器。
     *
     * @param requester 测试用例的{@code API}请求器
     */
    void setRequester(Requester<R, T> requester);

    /**
     * 获取测试用例的{@code API}请求器请求结果数据的处理器。
     *
     * @return 测试用例的{@code API}请求器请求结果数据的处理器
     */
    ResponseHandler<Report, R> getResponseHandler();

    /**
     * 设置测试用例的{@code API}请求器请求结果数据的处理器。
     *
     * @param responseHandler 测试用例的{@code API}请求器请求结果数据的处理器
     */
    void setResponseHandler(ResponseHandler<Report, R> responseHandler);

    /**
     * 获取测试用例的测试报告。
     *
     * @return 测试用例的测试报告
     */
    Report getReport();

    /**
     * 设置测试用例的测试报告。
     *
     * @param report 测试用例的测试报告
     */
    void setReport(Report report);

    /**
     * 获取测试用例的启动测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @return 测试用例的启动测试时间的毫秒数
     */
    Long getStartTime();

    /**
     * 设置测试用例的启动测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @param startTime 测试用例的启动测试时间的毫秒数
     */
    void setStartTime(Long startTime);

    /**
     * 获取测试用例的结束测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @return 测试用例的结束测试时间的毫秒数
     */
    Long getEndTime();

    /**
     * 设置测试用例的结束测试时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @param endTime 测试用例的结束测试时间的毫秒数
     */
    void setEndTime(Long endTime);
}