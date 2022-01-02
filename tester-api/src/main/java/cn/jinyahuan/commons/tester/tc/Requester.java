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

/**
 * 请求器的超类接口。
 * <p>此类用于测试用例调用{@code API}。
 *
 * @param <R> 返回值的类型
 * @param <T> 参数的类型
 * @author Yahuan Jin
 * @see ResponseHandler
 * @see TestCase
 * @see TestCaseGroup
 * @since 0.1
 */
public interface Requester<R, T> {
    /**
     * 发送请求。
     *
     * @param param 发送请求的参数
     * @return 请求的结果
     */
    R request(T param);
}