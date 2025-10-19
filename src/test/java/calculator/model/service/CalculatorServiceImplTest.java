package calculator.model.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    @DisplayName("일반 구분자로 구분된 문자열이 유저 입력으로 들어와도 계산에 성공한다.")
    void success_default_calculate() {

        // given
        String userInput = "1,2,3";
        double expected = 6D;

        // when
        double result = calculatorService.calculate(userInput);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열이 유저 입력으로 들어와도 계산에 성공한다.")
    void success_custom_calculate() {

        // given
        String userInput = "//;\n1;2;3";
        double expected = 6D;

        // when
        double result = calculatorService.calculate(userInput);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("형식이 잘못된 문자열이 들어오는 경우 IllegalArgumentException을 발생시킨다")
    void fail_calculate() {

        // given
        String userInput = "/;\\n1;2;3";

        // when & then
        assertThatThrownBy(() -> calculatorService.calculate(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}