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

import cn.jinyahuan.commons.tester.report.Report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 质检员接口的一个抽象类，主要用于快速完成一个实现类。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public abstract class AbstractInspector implements Inspector {
    /** 默认的存放测试用例的容器的初始容量大小 */
    private static final int DEFAULT_INIT_CAPACITY = 256;

    /** 存放测试用例的容器的初始容量大小 */
    protected int initCapacity;
    /** 存放测试用例的容器。key 为测试用例的编号，value 为测试用例实例 */
    protected Map<String, TestCaseService> testCases;
    /** 存放测试用例报告的容器。key 为测试用例的编号，value 为测试用例的报告实例 */
    protected Map<String, Report> reports;

    public AbstractInspector() {
        this(DEFAULT_INIT_CAPACITY);
    }

    /**
     * @param initCapacity 存放测试用例的容器的初始容量大小，尽量与测试用例数接近
     */
    public AbstractInspector(int initCapacity) {
        this.initCapacity = initCapacity;
        instanceInit();
    }

    @Override
    public void collect(TestCaseService tc) {
        // 子类来实现具体的操作
    }

    @Override
    public void interrupt() {
        doBeforeExit();

        System.exit(-1);
    }

    /**
     * 当实例化一个对象时会触发此方法。
     */
    protected void instanceInit() {
        testCases = new ConcurrentHashMap<>(this.initCapacity);
        reports = new ConcurrentHashMap<>(this.initCapacity);
    }

    protected void doBeforeExit() {
        // 子类来实现具体的操作
    }
}
