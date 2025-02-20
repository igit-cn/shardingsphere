/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.database.core.metadata.database.enums;

import com.google.common.base.Strings;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Quote character.
 */
@RequiredArgsConstructor
@Getter
public enum QuoteCharacter {
    
    BACK_QUOTE("`", "`"),
    
    SINGLE_QUOTE("'", "'"),
    
    QUOTE("\"", "\""),
    
    BRACKETS("[", "]"),
    
    PARENTHESES("(", ")"),
    
    NONE("", "");
    
    private static final Map<Character, QuoteCharacter> BY_FIRST_CHAR = new HashMap<>(QuoteCharacter.values().length - 1, 1L);
    
    static {
        for (QuoteCharacter each : values()) {
            if (each.equals(NONE)) {
                continue;
            }
            BY_FIRST_CHAR.put(each.startDelimiter.charAt(0), each);
        }
    }
    
    private final String startDelimiter;
    
    private final String endDelimiter;
    
    /**
     * Get quote character.
     * 
     * @param value value to be get quote character
     * @return value of quote character
     */
    public static QuoteCharacter getQuoteCharacter(final String value) {
        if (Strings.isNullOrEmpty(value)) {
            return NONE;
        }
        return BY_FIRST_CHAR.getOrDefault(value.charAt(0), NONE);
    }
    
    /**
     * Wrap value with quote character.
     * 
     * @param value value to be wrapped
     * @return wrapped value
     */
    public String wrap(final String value) {
        return startDelimiter + value + endDelimiter;
    }
    
    /**
     * Unwrap value with quote character.
     *
     * @param value value to be unwrapped
     * @return unwrapped value
     */
    public String unwrap(final String value) {
        return isWrapped(value) ? value.substring(startDelimiter.length(), value.length() - endDelimiter.length()) : value;
    }
    
    /**
     * Is wrapped by quote character.
     * 
     * @param value value to be judged
     * @return is wrapped or not
     */
    public boolean isWrapped(final String value) {
        return value.startsWith(startDelimiter) && value.endsWith(endDelimiter);
    }
}
