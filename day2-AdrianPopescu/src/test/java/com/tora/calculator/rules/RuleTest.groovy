package com.tora.calculator.rules

import com.tora.parser.Parser
import spock.lang.Specification

import static com.tora.types.Functions.*

class RuleTest extends Specification {

    def 'match syntax of simple sum'() {
        given:
        def operation = '50 + 100'

        when:
        def internalForm = Parser.parse(operation)

        then:
        PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of simple sum attempt, improper arguments'() {
        given:
        def operation = '50 + '

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of minus'() {
        given:
        def operation = '1235.234 - 125'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of product'() {
        given:
        def operation = '145 * 2345'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of division'() {
        given:
        def operation = '15.667 / 123.634'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of min, correct arguments'() {
        given:
        def operation = 'min 12 6 2 76 7 5 7.5 93 15'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of min attempt, missing parameters'() {
        given:
        def operation = 'min'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of max'() {
        given:
        def operation = 'max 3 6236 275 547'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        MAX.rule().matchSyntax(internalForm)
        !SQRT.rule().matchSyntax(internalForm)
    }

    def 'match syntax of sqrt'() {
        given:
        def operation = 'sqrt 6.7654'

        when:
        def internalForm = Parser.parse(operation)

        then:
        !PLUS.rule().matchSyntax(internalForm)
        !MINUS.rule().matchSyntax(internalForm)
        !PRODUCT.rule().matchSyntax(internalForm)
        !DIVISION.rule().matchSyntax(internalForm)
        !MIN.rule().matchSyntax(internalForm)
        !MAX.rule().matchSyntax(internalForm)
        SQRT.rule().matchSyntax(internalForm)
    }

    def 'compute sum'() {
        given:
        def operation = '10 + 20'

        when:
        def internalForm = Parser.parse(operation)

        then:
        Double.compare(PLUS.rule().compute(internalForm).get(), 30) == 0
    }

    def 'compute subtraction'() {
        given:
        def operation = '15.111 - 10.110'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(MINUS.rule().compute(internalForm).get(), 5.001)
    }

    private static final boolean equalsDouble(final double first, final double second) {
        return first - second < 0.0000000001
    }

    def 'compute product'() {
        given:
        def operation = '25.0005 * 4'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(PRODUCT.rule().compute(internalForm).get(), 100.002)
    }

    def 'compute division'() {
        given:
        def operation = '16 / 5'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(DIVISION.rule().compute(internalForm).get(), 3.2)
    }

    def 'compute min'() {
        given:
        def operation = 'min 73 16 25 5 14'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(MIN.rule().compute(internalForm).get(), 5)
    }

    def 'compute max'() {
        given:
        def operation = 'max 73 16 25 5 14'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(MAX.rule().compute(internalForm).get(), 73)
    }

    def 'compute sqrt'() {
        given:
        def operation = 'sqrt 16'

        when:
        def internalForm = Parser.parse(operation)

        then:
        equalsDouble(SQRT.rule().compute(internalForm).get(), 4)
    }
}
