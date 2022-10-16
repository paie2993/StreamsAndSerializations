package com.tora.calculator.rules;

import com.tora.types.Types;
import com.tora.structure.StructureMatcher;

import java.util.Map;

import static com.tora.types.Types.FUNCTION;
import static com.tora.types.Types.VALUE;

final public class RulesProperties {

    /**
     * f = Function encoding
     */
    public static final String f;

    /**
     * v = Value encoding
     */
    public static final String v;

    static {
        final Map<Types, String> encodings = StructureMatcher.encodings;
        assertEncoding(encodings, FUNCTION, "Function encoding not available in StructureMatcher");
        assertEncoding(encodings, VALUE, "Value encoding not available in StructureMatcher");

        f = encodings.get(FUNCTION);
        v = encodings.get(VALUE);
    }

    public static final String binaryStructure = "^" + v + f + v + "$";
    public static final int binaryFunctionSymbolIndex = 1;
    public static final int binaryFirstValueIndex = 0;
    public static final int binarySecondValueIndex = 2;

    public static final String listFunctionStructure = "^" + f + v + "+$";
    public static final int listFunctionSymbolIndex = 0;

    public static final String unaryStructure = "^" + f + v + "$";
    public static final int unaryFunctionSymbolIndex = 0;
    public static final int unaryFunctionValueIndex = 1;

    private static void assertEncoding(
            final Map<Types, String> encodings,
            Types type,
            final String errorMessage
    ) {
        if (!encodings.containsKey(type)) {
            throw new RuntimeException(errorMessage);
        }
    }
}
