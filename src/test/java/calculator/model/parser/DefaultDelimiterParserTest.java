package calculator.model.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DefaultDelimiterParserTest {

    private final DefaultDelimiterParser defaultDelimiterParser = new DefaultDelimiterParser();

    @Nested
    @DisplayName("기본 구분자 분리 테스트")
    class DefaultDelimetersTest {

        @Test
        @DisplayName("쉼표(,)로 구분된 문자열을 입력시 분리된 문자열 리스트가 분리한다.")
        void success_split_string_by_rest() {

            // given
            String testInput = "1,2,3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = defaultDelimiterParser.parse(testInput);

            // then
            assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }

        @Test
        @DisplayName("콜론(:)으로 구분된 문자열을 입력시 올바르게 문자열이 분리한다.")
        void success_split_string_by_colon() {

            // given
            String testInput = "1.2:3";
            List<String> expected = List.of("1.2", "3");

            // when
            List<String> result = defaultDelimiterParser.parse(testInput);

            // then
            assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }

        @Test
        @DisplayName("쉼표와 콜론이 함께 입력된 문자열을 입력시 올바르게 문자열이 분리한다.")
        void success_split_string_by_two_delimeters() {

            // given
            String testInput = "1:2,3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = defaultDelimiterParser.parse(testInput);

            // then
            assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }

        @Test
        @DisplayName("마침표/소수점(.)이 포함된 문자열을 입력시 올바르게 문자열을 분리한다.")
        void success_string_contains_quote() {

            // given
            String testInput = "1.2,3";
            List<String> expected = List.of("1.2", "3");

            // when
            List<String> result = defaultDelimiterParser.parse(testInput);

            // then
            assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }
    }
}