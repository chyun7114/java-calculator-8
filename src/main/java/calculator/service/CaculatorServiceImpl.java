package calculator.service;

import java.util.List;

public class CaculatorServiceImpl implements CalculatorService {

    @Override
    public List<String> splitByDelimeters(String input) {
        return List.of(input.split(",|:"));
    }
}
