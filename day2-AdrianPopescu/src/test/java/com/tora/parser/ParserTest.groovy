package com.tora.parser

import com.tora.program.Term
import spock.lang.Specification

import static com.tora.types.Types.*

class ParserTest extends Specification {

    def 'Parse test, simple sum, correct arguments'() {
        given:
        def expression = '1 + 2'

        when:
        def internal = Parser.parse(expression)

        then:
        internal.program()[0] == new Term(VALUE, 0)
        internal.program()[1] == new Term(FUNCTION, 0)
        internal.program()[2] == new Term(VALUE, 1)
    }

    def 'Parse test, max, correct arguments'() {
        given:
        def expression = 'max 5 1 6'

        when:
        def internal = Parser.parse(expression)

        then:
        internal.program()[0] == new Term(FUNCTION, 0)
        internal.program()[1] == new Term(VALUE, 0)
        internal.program()[2] == new Term(VALUE, 1)
        internal.program()[3] == new Term(VALUE, 2)
    }

    def 'Parse test, sqrt, improper argument'() {
        given:
        def expression = 'sqrt a'

        when:
        Parser.parse(expression)

        then:
        thrown NumberFormatException
    }
}