package calculator.model.parser;

import java.util.List;

public class DefaultDelimiterParser implements InputParser {

    private static final String DEFAULT_DELIMETERS = ",|:";

    @Override
    public List<String> parse(String input) {
        return List.of(input.split(DEFAULT_DELIMETERS));
    }
}
