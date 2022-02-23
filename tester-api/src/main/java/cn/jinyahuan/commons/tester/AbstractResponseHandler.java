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
 * {@code API}的请求结果的处理器的抽象类实现，方便快速实现一个{@code API}的请求结果的处理器类。
 * <p>骨架已经搭好了，只要赋值{@link #param}，并覆写{@link #doHandle()}方法，
 * 然后执行{@link #handle()}方法，如果没有发生非预期的情况，则会生成处理结果。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public abstract class AbstractResponseHandler<R, T> implements ResponseHandler<R, T> {
    /** 处理器的执行参数，也就是{@link Requester 请求器}的请求结果 */
    protected T param;
    /** 处理器的执行结果 */
    protected R result;
    /** 处理请求结果前的时间的纳秒数（与系统时间无关） */
    protected Long startTime;
    /** 处理请求结果的时间的纳秒数（与系统时间无关） */
    protected Long endTime;

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
    public R handle(T param) {
        setParam(param);
        return handle();
    }

    @Override
    public R handle() {
        beforeHandle();
        R result = doHandle();
        afterHandle(result);
        return result;
    }

    protected void beforeHandle() {
        setStartTime(System.nanoTime());
    }

    abstract R doHandle();

    protected void afterHandle(R result) {
        setEndTime(System.nanoTime());
        setResult(result);
    }
}
