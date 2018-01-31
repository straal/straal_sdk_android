/*
 * ValidationError.java
 * Created by Konrad Kowalewski on 26.01.18
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

package com.straal.sdk.validation;

import java.util.EnumSet;

public enum ValidationResult {
    VALID,
    CARD_PATTERN_NOT_MATCHED,
    CARD_NUMBER_NOT_NUMERIC,
    INCOMPLETE,
    CARD_NUMBER_TOO_LONG,
    LUHN_TEST_FAILED,
    CARDHOLDER_NAME_TOO_SHORT,
    CVV_INVALID,
    CVV_INCOMPLETE,
    EXPIRY_DATE_INVALID,
    CARD_EXPIRED;

    public static EnumSet<ValidationResult> emptySet() {
        return EnumSet.noneOf(ValidationResult.class);
    }
}
