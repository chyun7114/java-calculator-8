package calculator.model.parser;

public class InputParserFactory {

    private static final String START_CUSTOM_DELIMITER = "//";

    public InputParserFactory() {
        throw new UnsupportedOperationException("this is factory class");
    }

    public static InputParser getParser(String input) {
        if (input.startsWith(START_CUSTOM_DELIMITER)) {
            return new CustomDelimiterParser();
        }
        return new DefaultDelimiterParser();
    }
}
