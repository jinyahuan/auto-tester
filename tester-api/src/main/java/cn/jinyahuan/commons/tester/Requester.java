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
 * {@code API}请求器的超类接口。
 * <p>此类用于发送{@code API}请求，获取{@code API}的请求结果。
 * 有了{@code API}的请求结果后，可以将其交由{@link ResponseHandler}进行处理，
 * 处理之后获得一份{@link TestCase 测试报告}。
 * <p>{@code API}的请求 url 由 {@link ApiHost host} + {@link ApiPath path} 组成，
 * 例如：host 为 https://api.jinyahuan.cn, path 为 /acct/signin, 完整的 url 为 https://api.jinyahuan.cn/acct/signin.
 *
 * @param <R> 返回值的类型
 * @param <T> 参数的类型
 * @author Yahuan Jin
 * @see ResponseHandler
 * @see TestCase
 * @since 0.1
 */
public interface Requester<R, T> {
    /**
     * 获取请求器的 api host 信息。
     *
     * @return 请求器的 api host 信息
     */
    ApiHost getApiHost();

    /**
     * 设置请求器的 api host 信息
     *
     * @param apiHost 请求器的 api host 信息
     */
    void setApiHost(ApiHost apiHost);

    /**
     * 获取请求器的 api path 信息。
     *
     * @return 请求器的 api path 信息
     */
    ApiPath getApiPath();

    /**
     * 设置请求器的 api path 信息。
     *
     * @param apiPath 请求器的 api path 信息
     */
    void setApiPath(ApiPath apiPath);

    /**
     * 获取请求的参数。
     *
     * @return 请求的参数
     */
    T getParam();

    /**
     * 设置请求的参数。
     *
     * @param param 求的参数
     */
    void setParam(T param);

    /**
     * 获取请求后的结果数据。
     *
     * @return 请求后的结果数据
     */
    R getResult();

    /**
     * 设置请求后的结果数据。
     *
     * @param result 请求后的结果数据
     */
    void setResult(R result);

    /**
     * 获取请求{@code API}的开始时间毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @return 请求{@code API}的开始时间毫秒数
     */
    Long getStartTime();

    /**
     * 设置请求{@code API}的开始时间毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @param startTime 请求{@code API}的开始时间毫秒数
     */
    void setStartTime(Long startTime);

    /**
     * 获取请求{@code API}的结束时间毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @return 请求{@code API}的结束时间毫秒数
     */
    Long getEndTime();

    /**
     * 设置请求{@code API}的结束时间毫秒数（与 UTC 时间 1970-01-01 的毫秒数差）。
     *
     * @param endTime 请求{@code API}的结束时间毫秒数
     */
    void setEndTime(Long endTime);

    /**
     * 发送请求。
     *
     * @param param 发送请求的参数
     * @return 请求的结果
     */
    R request(T param);

    /**
     * 发送请求。
     *
     * @return 请求的结果
     */
    R request();
}
