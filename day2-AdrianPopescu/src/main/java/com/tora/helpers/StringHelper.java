package com.tora.helpers;

import com.tora.constants.Constants;

import java.util.Collection;

final public class StringHelper {
    public static String concatenate(Collection<String> strings) {
        return strings.stream().reduce((acc, curr) -> acc + curr).orElse(Constants.EMPTY);
    }
}
