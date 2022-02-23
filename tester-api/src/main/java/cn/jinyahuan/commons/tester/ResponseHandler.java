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

/**
 * {@code API}的请求结果的处理器的超类接口。
 * <p>执行{@link Requester 请求器}后获取{@code API}的请求结果后，
 * 可以将其交由此类的具体实现类进行处理，处理之后获得一份{@link TestCase 测试用例}，
 * 根据不同的处理策略来决定{@link TestCase 测试用例}是否可以通过测试。
 *
 * @param <R> 返回值的类型
 * @param <T> 参数的类型
 * @author Yahuan Jin
 * @see Requester
 * @see TestCase
 * @since 0.1
 */
public interface ResponseHandler<R, T> {
    /**
     * 获取处理器的执行参数，也就是{@link Requester 请求器}的请求结果。
     *
     * @return 处理器的执行参数
     */
    T getParam();

    /**
     * 获取设置的处理器的执行参数。
     *
     * @param param 设置的处理器的执行参数
     */
    void setParam(T param);

    /**
     * 获取处理器的执行结果。
     *
     * @return 处理器的执行结果
     */
    R getResult();

    /**
     * 设置处理器的执行结果。
     *
     * @param result 处理器的执行结果
     */
    void setResult(R result);

    /**
     * 获取请求{@code API}的开始时间。
     *
     * @return 请求{@code API}的开始时间
     */
    Long getStartTime();

    /**
     * 设置处理器的开始执行时间。
     *
     * @param startTime 处理器的开始执行时间
     */
    void setStartTime(Long startTime);

    /**
     * 获取处理器的结束执行时间。
     *
     * @return 处理器的结束执行时间
     */
    Long getEndTime();

    /**
     * 设置处理器的结束执行时间。
     *
     * @param endTime 处理器的结束执行时间
     */
    void setEndTime(Long endTime);

    /**
     * 处理。
     *
     * @param param 处理器的执行参数，一般来自执行{@link Requester#request(Object)}后的返回值
     * @return 处理结果
     */
    R handle(T param);

    /**
     * 处理。
     *
     * @return 处理结果
     */
    R handle();
}
