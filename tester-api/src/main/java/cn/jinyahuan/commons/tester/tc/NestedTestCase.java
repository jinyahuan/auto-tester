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
 * 嵌套的测试用例的超类接口。
 * <p>有关联关系的几个{@code API}以一定的顺序组合测试，比如登陆后查询账户信息，就是一个嵌套的操作，先登录然后查询账户信息。
 *
 * @param <T> 测试报告的类型
 * @author Yahuan Jin
 * @see TestCaseService
 * @see AbstractTestCaseService
 * @see Report
 * @see Requester
 * @see ResponseHandler
 * @see TestCaseGroup
 * @since 0.1
 */
public interface NestedTestCase<T> extends TestCase<T> {
    // todo 暂时还没想好怎么玩，1.0版应该也不会有这个功能
    // 如果有这个需求的，可以在{@code ResponseHandler}中多层嵌套{@code TestCase}来实现
    // 虽然代码丑了一点 -_-
}
