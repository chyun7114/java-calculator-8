package calculator.model.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputParserFactoryTest {

    @Test
    @DisplayName("InputParserFactory는 인스턴스화 할 수 없다.")
    void inputParserFactory_CannotBeInstantiated() {
        // when & then
        assertThatThrownBy(InputParserFactory::new)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("입력 문자열이 '//'으로 시작하면 CustomDelimeterParser를 반환한다.")
    void getParser_ForCustomDelimeterParser() {

        // given
        String inputWithCustomDelimeter = "//;\\n1;2;3";

        // when
        InputParser parser = InputParserFactory.getParser(inputWithCustomDelimeter);

        // then
        assertThat(parser).isInstanceOf(CustomDelimiterParser.class);
    }

    @Test
    @DisplayName("입력 문자열이 '//'으로 시작하지 않으면 DefaultDelimeterParser를 반환한다.")
    void getParser_ForDefaultDelimeterParser() {

        // given
        String inputWithCustomDelimeter = "1,2,3";

        // when
        InputParser parser = InputParserFactory.getParser(inputWithCustomDelimeter);

        // then
        assertThat(parser).isInstanceOf(DefaultDelimiterParser.class);
    }
}