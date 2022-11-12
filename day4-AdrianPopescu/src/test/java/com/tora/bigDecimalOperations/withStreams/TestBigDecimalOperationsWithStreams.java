package com.tora.bigDecimalOperations.withStreams;

import com.tora.bigDecimalOperations.BigDecimalOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class TestBigDecimalOperationsWithStreams {

    final BigDecimalOperations instance = BigDecimalOperationsWithStreams.instance();

    @Test
    void sum() {
        final List<BigDecimal> list = List.of(
                new BigDecimal("1.520"),
                new BigDecimal("1.200"),
                new BigDecimal("2.555"),
                new BigDecimal("3.450"),
                new BigDecimal("4.250"),
                new BigDecimal("5.150")
        );

        final BigDecimal sum = instance.sum(list);

        final int comparison = sum.compareTo(new BigDecimal("18.125"));
        Assertions.assertEquals(0, comparison);
    }

    @Test
    void averageForEmptyList() {
        final List<BigDecimal> list = List.of();

        final BigDecimal average = instance.average(list);

        final int comparison = average.compareTo(BigDecimal.ZERO);
        Assertions.assertEquals(0, comparison);
    }

    @Test
    void average() {
        final List<BigDecimal> list = List.of(
                new BigDecimal("1.520"),
                new BigDecimal("1.200"),
                new BigDecimal("2.555"),
                new BigDecimal("3.450"),
                new BigDecimal("4.250"),
                new BigDecimal("5.150")
        );
        final BigDecimal expected = new BigDecimal("3.021");

        final BigDecimal average = instance.average(list);

        final int comparison = average.compareTo(expected);
        Assertions.assertEquals(0, comparison);
    }

    @Test
    void topTenForEmpty() {
        final List<BigDecimal> list = List.of();
        final int expectedSize = 0;

        final List<BigDecimal> topTen = instance.topTen(list);

        Assertions.assertEquals(expectedSize, topTen.size());
    }

    @Test
    void topTenForFive() {
        final List<BigDecimal> list = List.of(
                new BigDecimal("1.500"),
                new BigDecimal("2.000"),
                new BigDecimal("2.500"),
                new BigDecimal("3.000"),
                new BigDecimal("3.500")
        );
        final List<BigDecimal> expectedList = List.of(
                new BigDecimal("3.500")
        );

        final List<BigDecimal> topTen = instance.topTen(list);

        final boolean comparison = equalsBigDecimalLists(expectedList, topTen);
        Assertions.assertTrue(comparison);
    }

    @Test
    void topTenForTen() {
        final List<BigDecimal> list = List.of(
                new BigDecimal("1.500"),
                new BigDecimal("2.000"),
                new BigDecimal("2.500"),
                new BigDecimal("3.000"),
                new BigDecimal("3.500"),
                new BigDecimal("4.000"),
                new BigDecimal("4.500"),
                new BigDecimal("5.000"),
                new BigDecimal("5.500"),
                new BigDecimal("6.000")
        );
        final List<BigDecimal> expectedList = List.of(
                new BigDecimal("6.000")
        );

        final List<BigDecimal> topTen = instance.topTen(list);

        final boolean comparison = equalsBigDecimalLists(expectedList, topTen);
        Assertions.assertTrue(comparison);
    }
    
    @Test
    void topTenForFifteen() {
        final List<BigDecimal> list = List.of(
                new BigDecimal("1.500"),
                new BigDecimal("2.000"),
                new BigDecimal("2.500"),
                new BigDecimal("3.000"),
                new BigDecimal("3.500"),
                new BigDecimal("4.000"),
                new BigDecimal("4.500"),
                new BigDecimal("5.000"),
                new BigDecimal("5.500"),
                new BigDecimal("6.000"),
                new BigDecimal("6.500"),
                new BigDecimal("7.000"),
                new BigDecimal("7.500"),
                new BigDecimal("8.000"),
                new BigDecimal("8.500")
        );
        final List<BigDecimal> expectedList = List.of(
                new BigDecimal("8.500"),
                new BigDecimal("8.000")
        );

        final List<BigDecimal> topTen = instance.topTen(list);

        final boolean comparison = equalsBigDecimalLists(expectedList, topTen);
        Assertions.assertTrue(comparison);
    }

    @Test
    void generate() {
        final BigDecimal lowerLimit = BigDecimal.ONE;
        final int numbers = 5;

        final List<BigDecimal> list = instance.generate(lowerLimit, numbers);
        final List<BigDecimal> expected = List.of(
                BigDecimal.ONE,
                new BigDecimal(2),
                new BigDecimal(3),
                new BigDecimal(4),
                new BigDecimal(5)
        );

        final boolean equalsLists = equalsBigDecimalLists(expected, list);
        Assertions.assertTrue(equalsLists);
    }

    private static boolean equalsBigDecimalLists(final List<BigDecimal> first, final List<BigDecimal> second) {
        if (!equalsSizes(first, second)) {
            return false;
        }

        return equalsPairwise(first, second);
    }

    private static boolean equalsSizes(final List<BigDecimal> first, final List<BigDecimal> second) {
        return first.size() == second.size();
    }

    private static boolean equalsPairwise(final List<BigDecimal> first, final List<BigDecimal> second) {
        assertListSizesEqual(first, second);

        int size = first.size();
        for (int i = 0; i < size; i++) {
            final boolean equal = (0 == first.get(i).compareTo(second.get(i)));
            if (!equal) {
                return false;
            }
        }
        return true;
    }

    private static void assertListSizesEqual(final List<?> first, final List<?> second) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Sizes of the two lists are not equals");
        }
    }
}