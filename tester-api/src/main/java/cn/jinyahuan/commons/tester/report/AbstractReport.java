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

package cn.jinyahuan.commons.tester.report;

/**
 * 测试报告的超类抽象类。
 *
 * @author Yahuan Jin
 * @see Report
 * @see DefaultReport
 * @since 0.1
 */
public abstract class AbstractReport implements Report {
    /** 测试用例编号 */
    protected String testCaseNo;
    /** 报告的状态 */
    protected ReportStatus status;
    /** 报告的摘要信息 */
    protected String msg;

    public AbstractReport() {}

    public AbstractReport(String testCaseNo, ReportStatus status, String msg) {
        this.testCaseNo = testCaseNo;
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String getTestCaseNo() {
        return testCaseNo;
    }

    @Override
    public void setTestCaseNo(String testCaseNo) {
        this.testCaseNo = testCaseNo;
    }

    @Override
    public ReportStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
