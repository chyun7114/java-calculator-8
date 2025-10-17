package calculator.model.parser;

import java.util.List;
import java.util.regex.Pattern;

public class CustomDelimiterParser implements InputParser {

    private static final String START_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\n";
    private static final String DEFAULT_DELIMITERS = ",|:";

    @Override
    public List<String> parse(String input) {
        input = input.replace("\\n", END_CUSTOM_DELIMITER);

        String[] parts = input.split(END_CUSTOM_DELIMITER, 2);
        String customDelimiter = parts[0].substring(START_CUSTOM_DELIMITER.length());

        String regex = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS;

        return List.of(parts[1].split(regex));
    }
}
