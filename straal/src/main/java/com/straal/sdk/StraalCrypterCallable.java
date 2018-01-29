/*
 * StraalCrypterCallable.java
 * Created by Arkadiusz Różalski on 26.01.18
 * Straal SDK for Android
 * Copyright 2018 Straal Sp. z o. o.
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

package com.straal.sdk;

import com.straal.sdk.response.KeyResponse;

import java.util.concurrent.Callable;

class StraalCrypterCallable implements Callable<StraalCrypter> {
    private final Callable<KeyResponse> keyResponseCallable;

    StraalCrypterCallable(Callable<KeyResponse> keyResponseCallable) {
        this.keyResponseCallable = keyResponseCallable;
    }

    @Override
    public StraalCrypter call() throws Exception {
        return new StraalCrypter(keyResponseCallable.call().key);
    }
}
