package calculator.service;

import java.util.List;
import java.util.regex.Pattern;

public class CaculatorServiceImpl implements CalculatorService {

    @Override
    public List<String> splitByDelimeters(String input) {

        String customDelimeter = findCustomDelimeters(input);

        if(customDelimeter == null) {
            return List.of(input.split(",|:"));
        }

        String changedInput = input.substring(input.indexOf("\n") + 1);

        if(customDelimeter.isEmpty()) {
            return List.of(changedInput.split(",|:"));
        }


        String regex = Pattern.quote(customDelimeter) + "|" + ",|:";

        return List.of(changedInput.split(regex));
    }

    private String findCustomDelimeters(String input) {

        // 문자열 앞 부분에 //이 없는 경우는 커스텀 구분자 아님
        if(!input.startsWith("//"))
            return null;

        String[] customParts = input.split("\n", 2);

        // \n을 기준으로 잘린 문자열의 앞 부분은 커스텀 구분자 후보
        String partsOfHeader = customParts[0];

        return partsOfHeader.substring(2);
    }
}
