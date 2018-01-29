/*
 * CardNumberValidatorTest.java
 * Created by Arkadiusz Różalski on 26.01.18
 * Straal SDK for Android Tests
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

import com.straal.sdk.card.CreditCard;
import com.straal.sdk.card.ExpiryDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CardNumberValidator")
class CardNumberValidatorTest {
    private CardNumberValidator cardNumberValidator = new CardNumberValidator();

    @ParameterizedTest
    @MethodSource({"cardNumbers"})
    void validate(String cardNumber, EnumSet<ValidationError> expectedErrors) {
        CreditCard card = new CreditCard("John Smith", cardNumber, "123", new ExpiryDate(12, 2200));
        EnumSet<ValidationError> errors = cardNumberValidator.validate(card);
        assertEquals(expectedErrors, errors);
    }

    static Stream<Arguments> cardNumbers() {
        return Stream.of(
                Arguments.of("444444444a444448", EnumSet.of(
                        ValidationError.CARD_PATTERN_NOT_MATCHED,
                        ValidationError.CARD_NUMBER_NOT_NUMERIC
                )),
                Arguments.of("444444444444444", EnumSet.of(
                        ValidationError.CARD_NUMBER_INCOMPLETE,
                        ValidationError.CARD_PATTERN_NOT_MATCHED,
                        ValidationError.LUHN_TEST_FAILED
                )),
                Arguments.of("44444444444444488", EnumSet.of(
                        ValidationError.CARD_NUMBER_TOO_LONG,
                        ValidationError.CARD_PATTERN_NOT_MATCHED,
                        ValidationError.LUHN_TEST_FAILED
                )),
                Arguments.of("4444444444444444", EnumSet.of(
                        ValidationError.LUHN_TEST_FAILED
                )),
                Arguments.of("1111111111111111", EnumSet.of(
                        ValidationError.CARD_PATTERN_NOT_MATCHED
                )),
                Arguments.of("4444444444444448", ValidationError.emptySet())
        );
    }
}