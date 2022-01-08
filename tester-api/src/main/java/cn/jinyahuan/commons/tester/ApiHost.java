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
 * Api host 的超类接口。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public interface ApiHost {
    /**
     * 获取 host 地址。
     *
     * @return host 地址
     */
    String getHost();

    /**
     * 获取 host 的助记名称。
     *
     * @return host 的助记名称
     */
    String getName();

    /**
     * 获取 host 的摘要信息。
     *
     * @return host 的摘要信息
     */
    String getSummary();

    /**
     * 是否为正式环境的 host。
     * @return {@code true}，当且仅当当前的 host 实例为正式环境
     */
    boolean isProductEnvironment();
}
