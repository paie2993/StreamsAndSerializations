package com.tora.bigDecimalOperations.implementationsContainer;

import com.tora.serializers.simple.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InternalOperationsImplementations extends InternalOperations {

    private InternalOperationsImplementations() {

        this.sum = list -> list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        this.divide = (numerator, denominator) -> numerator.divide(denominator, RoundingMode.HALF_UP);

        this.average = list -> {
            if (list.size() == 0) {
                return BigDecimal.ZERO;
            }

            final BigDecimal numerator = sum.apply(list);
            final BigDecimal denominator = new BigDecimal(list.size());
            return divide.apply(numerator, denominator);
        };

        this.comparator = (o1, o2) -> {
            final int naturalComparison = o1.compareTo(o2);
            return -naturalComparison;
        };

        this.oneTenth = value -> {
            final BigDecimal valueAsBigDecimal = new BigDecimal(value);
            final BigDecimal division = valueAsBigDecimal.divide(BigDecimal.TEN, RoundingMode.HALF_UP);
            final BigInteger divisionAsBigInteger = division.toBigIntegerExact();
            return divisionAsBigInteger.intValue();
        };

        this.topTen = list -> {
            final int limitMaxSize = oneTenth.apply(list.size());
            return list.stream().sorted(comparator).limit(limitMaxSize).collect(Collectors.toList());
        };

        this.generate = (lowerLimit, numbers) ->
                Stream.iterate(0, (current) -> current + 1)
                        .limit(numbers)
                        .map(value -> lowerLimit.add(new BigDecimal(value)))
                        .collect(Collectors.toList());
    }

    private InternalOperationsImplementations(
            final String sumImplementationFileName,
            final String divideImplementationFileName,
            final String averageImplementationFileName,
            final String comparatorFilename,
            final String oneTenthImplementationFileName,
            final String topTenImplementationFileName,
            final String generatorImplementationFileName
    ) throws IOException, ClassNotFoundException {
        super();
        this.sum = SumSerializer.instance().deserialize(sumImplementationFileName);
        this.divide = DivideSerializer.instance().deserialize(divideImplementationFileName);
        this.average = AverageSerializer.instance().deserialize(averageImplementationFileName);
        this.comparator = BigDecimalComparatorSerializer.instance().deserialize(comparatorFilename);
        this.oneTenth = OneTenthSerializer.instance().deserialize(oneTenthImplementationFileName);
        this.topTen = TopTenSerializer.instance().deserialize(topTenImplementationFileName);
        this.generate = GenerateSerializer.instance().deserialize(generatorImplementationFileName);
    }

    private static final class LazyDeserializerHolder {
        private static final InternalOperationsImplementations INSTANCE = instantiateInternalOperationsImplementations();

        private static InternalOperationsImplementations instantiateInternalOperationsImplementations() {
            try {
                return new InternalOperationsImplementations(
                        Configuration.SUM_IMPLEMENTATION_FILE_NAME,
                        Configuration.DIVIDE_IMPLEMENTATION_FILE_NAME,
                        Configuration.AVERAGE_IMPLEMENTATION_FILE_NAME,
                        Configuration.DESCENDING_COMPARATOR_FILE_NAME,
                        Configuration.ONE_TENTH_IMPLEMENTATION_FILE_NAME,
                        Configuration.TOP_TEN_IMPLEMENTATION_FILE_NAME,
                        Configuration.GENERATE_IMPLEMENTATION_FILE_NAME
                );
            } catch (IOException | ClassNotFoundException exception) {
                throw new ExceptionInInitializerError(exception);
            }
        }
    }

    private static final class LazyDefaultHolder {
        private static final InternalOperationsImplementations INSTANCE = new InternalOperationsImplementations();
    }

    public static InternalOperationsImplementations deserializedImplementationsInstance() {
        return LazyDeserializerHolder.INSTANCE;
    }

    public static InternalOperationsImplementations defaultImplementationsInstance() {
        return LazyDefaultHolder.INSTANCE;
    }
}
