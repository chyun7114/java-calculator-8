package calculator.model.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CustomDelimiterParserTest {

    private InputParser parser;

    @BeforeEach
    void setUp() {
        parser = new CustomDelimiterParser();
    }

    @Nested
    @DisplayName("커스텀 구분자 분리 테스트")
    class CustomDelimetersTest {

        @Test
        @DisplayName("커스텀 구분자로 구분된 문자열을 입력시 올바르게 문자열을 분리한다.")
        void success_custom_delimeters() {

            // given
            String testInput = "//;\\n1;2;3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자로 기존 구분자와 같은 내용이 들어와도 올바르게 문자열을 분리한다.")
        void success_custom_and_default_delimeters() {

            // given
            String testInput = "//:\\n1:2:3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자와 기본 구분자가 섞여도 올바르게 문자열을 분리한다.")
        void success_mixed_custom_and_default_delimeters() {

            // given
            String testInput = "//;\\n1,2;3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자에 (.)이 들어와도 올바르게 문자를 분리한다.")
        void success_custom_delimeters_contains_quote() {

            // given
            String testInput = "//.\\n1.2,3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자로 빈 문자열이 들어와도 올바르게 문자를 분리한다.")
        void success_custom_delimeters_is_empty() {

            // given
            String testInput = "//\\n1,2,3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자로 공백 문자열이 들어와도 올바르게 문자를 분리한다.")
        void success_custom_delimeters_is_blank() {

            // given
            String testInput = "// \\n1 2 3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }

        @Test
        @DisplayName("커스텀 구분자가 여러 글자여도 올바르게 문자를 분리한다.")
        void success_custom_delimeters_is_multiple() {

            // given
            String testInput = "//;;,,\\n1;;,,2;;,,3";
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = parser.parse(testInput);

            // then
            assertThat(result).containsAll(expected);
        }
    }
}