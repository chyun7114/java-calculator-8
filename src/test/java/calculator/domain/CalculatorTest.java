package calculator.domain;

import calculator.model.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Nested
    @DisplayName("분리된 숫자 값의 합을 반환한다.")
    class Calculate {

        @Test
        @DisplayName("구분자로 분리된 숫자 값의 합을 반환한다.")
        void success_calculate() {

            // given
            List<String> testInput = List.of("1", "2", "3");
            double expected = 6;

            // when
            double result = calculator.calculate(testInput);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("소수점이 입력되어도 숫자 값의 합을 반환한다.")
        void success_calculate_decimal_number() {

            // given
            List<String> testInput = List.of("1.2", "3");
            double expected = 4.2;

            // when
            double result = calculator.calculate(testInput);

            // then
            assertThat(result).isEqualTo(expected);
        }
        
        @Test
        @DisplayName("빈 리스트가 들어온 경우 0을 반환한다.")
        void success_is_empty_list() {

            // given
            List<String> testInput = List.of();
            double expected = 0;

            // when
            double result = calculator.calculate(testInput);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("잘못된 값이 입력 된 경우 IllegalArgumentException을 발생시킨다")
        void fail_calculate() {

            // given
            List<String> testInput = List.of("h", "2", "3");

            // when & then
            assertThatThrownBy(() -> calculator.calculate(testInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}