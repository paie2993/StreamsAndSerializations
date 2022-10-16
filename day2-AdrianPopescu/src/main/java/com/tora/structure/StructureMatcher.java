package com.tora.structure;

import com.tora.helpers.StringHelper;
import com.tora.types.Types;
import com.tora.program.InternalForm;
import com.tora.program.Term;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

final public class StructureMatcher {

    public static final Map<Types, String> encodings;

    static {
        encodings = new HashMap<>();
        encodings.put(Types.FUNCTION, "F");
        encodings.put(Types.VALUE, "V");
    }

    public static boolean match(InternalForm internalForm, String structureRegex) {
        final String actualTypesEncoding = getTypesEncodings(internalForm);
        return Pattern.matches(structureRegex, actualTypesEncoding);
    }

    private static String getTypesEncodings(InternalForm internalForm) {
        final List<Types> actualTypes = getActualTypes(internalForm);
        final List<String> encodings = encodeActualTypes(actualTypes);
        return StringHelper.concatenate(encodings);
    }

    private static List<Types> getActualTypes(InternalForm internalForm) {
        return internalForm.program().stream().map(Term::type).collect(Collectors.toList());
    }

    private static List<String> encodeActualTypes(List<Types> actualTypes) {
        return actualTypes.stream().map(type -> {
            if (!encodings.containsKey(type)) {
                throw new RuntimeException("Type does not have registered encoding: " + type);
            }
            return encodings.get(type);
        }).collect(Collectors.toList());
    }
}
