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
 * @author Yahuan Jin
 * @since 0.1
 */
public enum ApiHostDemo implements ApiHost {
    LOCAL("127.0.0.1", "local", "本地环境", false),
    DEVELOPMENT("192.168.1.90", "dev", "开发环境", false),
    TEST("192.168.1.91", "test", "测试环境", false),
    PRE_PRODUCT("192.168.1.99", "pre", "灰度环境", false),
    PRODUCT("192.168.1.100", "prod", "生产环境", true),
    ;

    private final String host;
    private final String name;
    private final String summary;
    private final boolean isProductEnvironment;

    ApiHostDemo(String host, String name, String summary, boolean isProductEnvironment) {
        this.host = host;
        this.name = name;
        this.summary = summary;
        this.isProductEnvironment = isProductEnvironment;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public boolean isProductEnvironment() {
        return isProductEnvironment;
    }
}