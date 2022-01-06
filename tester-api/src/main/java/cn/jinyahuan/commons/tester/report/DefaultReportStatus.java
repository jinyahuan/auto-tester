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
 * 默认的测试报告状态枚举类。
 *
 * @author Yahuan Jin
 * @see ReportStatus
 * @see Report
 * @since 0.1
 */
public enum DefaultReportStatus implements ReportStatus {
    /**
     * 通过。
     */
    PASS(Integer.MIN_VALUE, "通过", true),
    /**
     * 跳过。
     */
    SKIP(Integer.MIN_VALUE + 1, "跳过", true),
    /**
     * 失败。
     */
    FAIL(Integer.MAX_VALUE, "失败", false),
    ;

    private final int value;
    private final String summary;
    private final boolean pass;

    DefaultReportStatus(int value, String summary, boolean pass) {
        this.value = value;
        this.summary = summary;
        this.pass = pass;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    /**
     * 当前的状态是否为通过测试的状态。
     *
     * @return {@code true}，当且仅当前的状态为通过测试的状态
     * @see #isPassed(ReportStatus)
     * @see #nonPassed(ReportStatus)
     */
    @Override
    public boolean isPass() {
        return pass;
    }
}
