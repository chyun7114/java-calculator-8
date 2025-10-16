package calculator.service;

import java.util.List;
import java.util.regex.Pattern;

public class CalculatorServiceImpl implements CalculatorService {

    private static final String START_CUSTOM_DELIMETERS = "//";
    private static final String END_CUSTOM_DELIMETERS = "\n";
    private static final String DEFAULT_DELIMETERS = ",|:";

    @Override
    public List<String> splitByDelimeters(String input) {

        String customDelimeter = findCustomDelimeters(input);

        if(customDelimeter == null) {
            return List.of(input.split(DEFAULT_DELIMETERS));
        }

        String changedInput = input.substring(input.indexOf(END_CUSTOM_DELIMETERS) + 1);

        if(customDelimeter.isEmpty()) {
            return List.of(changedInput.split(DEFAULT_DELIMETERS));
        }


        String regex = Pattern.quote(customDelimeter) + "|" + DEFAULT_DELIMETERS;

        return List.of(changedInput.split(regex));
    }

    private String findCustomDelimeters(String input) {

        // 문자열 앞 부분에 //이 없는 경우는 커스텀 구분자 아님
        if(!input.startsWith(START_CUSTOM_DELIMETERS))
            return null;

        String[] customParts = input.split(END_CUSTOM_DELIMETERS, 2);

        // \n을 기준으로 잘린 문자열의 앞 부분은 커스텀 구분자 후보
        String partsOfHeader = customParts[0];

        return partsOfHeader.substring(2);
    }
}
