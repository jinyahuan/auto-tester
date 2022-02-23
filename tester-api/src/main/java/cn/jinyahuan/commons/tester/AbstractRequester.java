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
 * {@code API}请求器的抽象类实现，方便快速实现一个{@code API}请求器类。
 * <p>骨架已经搭好了，只要赋值{@link #apiHost}、{@link #apiPath}、{@link #param}，并覆写{@link #doRequest()}方法，
 * 然后执行{@link #request()}方法，如果没有发生非预期的情况，则会获取到请求的结果数据。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public abstract class AbstractRequester<R, T> implements Requester<R, T> {
    protected ApiHost apiHost;
    protected ApiPath apiPath;
    /** 请求的参数 */
    protected T param;
    /** 请求后的结果数据 */
    protected R result;
    /** 发送请求前的时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差） */
    protected Long startTime;
    /** 请求完成后的时间的毫秒数（与 UTC 时间 1970-01-01 的毫秒数差） */
    protected Long endTime;

    @Override
    public ApiHost getApiHost() {
        return apiHost;
    }

    @Override
    public void setApiHost(ApiHost apiHost) {
        this.apiHost = apiHost;
    }

    @Override
    public ApiPath getApiPath() {
        return apiPath;
    }

    @Override
    public void setApiPath(ApiPath apiPath) {
        this.apiPath = apiPath;
    }

    @Override
    public T getParam() {
        return param;
    }

    @Override
    public void setParam(T param) {
        this.param = param;
    }

    @Override
    public R getResult() {
        return result;
    }

    @Override
    public void setResult(R result) {
        this.result = result;
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
    public R request(T param) {
        setParam(param);
        return request();
    }

    @Override
    public R request() {
        beforeRequest();
        R response = doRequest();
        afterRequest(response);
        return response;
    }

    protected void beforeRequest() {
        setStartTime(System.currentTimeMillis());
    }

    abstract R doRequest();

    protected void afterRequest(R response) {
        setEndTime(System.currentTimeMillis());
        setResult(response);
    }
}
