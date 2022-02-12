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
 * 本来做适配使用。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public abstract class AbstractInspector implements Inspector {
    private static final int DEFAULT_CAPACITY = 1024;

    private final int capacity;

    protected final Map<String, TestCaseService> testCases;
    protected final Map<String, Report> reports;

    public AbstractInspector() {
        this(DEFAULT_CAPACITY);
    }

    public AbstractInspector(int capacity) {
        this.capacity = capacity;

        testCases = new ConcurrentHashMap<>(this.capacity);
        reports = new ConcurrentHashMap<>(this.capacity);
    }

    @Override
    public void collect(TestCaseService tc) {
        // 子类来实现具体的操作
    }

    @Override
    public void collect(Report report) {
        // 子类来实现具体的操作
    }

    @Override
    public void interrupt() {
        doBeforeExit();

        System.exit(-1);
    }

    protected void doBeforeExit() {
        // 子类来实现具体的操作
    }
}
