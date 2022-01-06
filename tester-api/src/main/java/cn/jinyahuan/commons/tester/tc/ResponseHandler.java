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
 * {@link Requester 请求器}响应参数的处理器的超类接口。
 * <p>此类用于处理{@code API}的请求结果，根据不同的处理策略来决定{@link TestCase 测试用例}是否可以通过测试。
 *
 * @param <R> 返回值的类型
 * @param <T> 参数的类型
 * @author Yahuan Jin
 * @see Requester
 * @see TestCase
 * @see TestCaseGroup
 * @since 0.1
 */
public interface ResponseHandler<R, T> {
    /**
     * 处理响应内容。
     *
     * @param param 响应的内容，执行{@link Requester#request(Object)}后的返回值
     * @return 处理结果
     */
    R handle(T param);

    // todo 请求参数、返回参数
}
