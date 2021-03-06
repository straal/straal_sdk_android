/*
 * HttpResponse.java
 * Created by Arkadiusz Różalski on 26.01.18
 * Straal SDK for Android
 * Copyright 2021 Straal Sp. z o. o.
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

package com.straal.sdk.http;

import java.util.List;
import java.util.Map;

public class HttpResponse {
    public final int code;
    public final String body;
    public final Map<String, List<String>> headerFields;

    public HttpResponse(int code, String body, Map<String, List<String>> headerFields) {
        this.code = code;
        this.body = body;
        this.headerFields = headerFields;
    }

    public static Boolean isSuccessful(int code) {
        return (200 <= code && code <= 299);
    }
}
