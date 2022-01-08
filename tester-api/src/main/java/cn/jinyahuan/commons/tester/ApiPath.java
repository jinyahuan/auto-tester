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
 * Api path 的超类接口。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public interface ApiPath {
    /**
     * 获取 api 的 path 地址。
     *
     * @return api 的 path 地址
     */
    String getPath();

    /**
     * 获取 api path 的标题。
     *
     * @return api path 的标题
     */
    String getTitle();

    /**
     * 获取 api path 的摘要信息。
     *
     * @return api path 的摘要信息
     */
    String getSummary();
}
