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

import java.util.Collection;
import java.util.List;

/**
 * 测试用例组的超类接口。
 * <p>此类用于线性的执行测试用例组内的所有测试用例。
 *
 * @author Yahuan Jin
 * @see Requester
 * @see ResponseHandler
 * @see TestCase
 * @since 0.1
 */
public interface TestCaseGroup {
    /**
     * 线性的对测试用例组内的所有测试用例进行测试。
     *
     * @return 测试结果
     */
    List<Report> testAll();

    String getGroupNo();

    void setGroupNo(String groupNo);

    boolean addTestCase(TestCase testCase);

    boolean addAllTestCase(Collection<TestCase> testCases);

    int size();
}