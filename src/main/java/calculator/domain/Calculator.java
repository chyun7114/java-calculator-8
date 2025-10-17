package calculator.domain;

import java.util.List;

public class Calculator {

    public double calculate(List<String> numbers) {

        double sum = 0;

        if(numbers.isEmpty()) return sum;

        for(String number : numbers) {
            try {
                if(Double.parseDouble(number) < 0)
                    throw new IllegalArgumentException();

                sum += Double.parseDouble(number);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
