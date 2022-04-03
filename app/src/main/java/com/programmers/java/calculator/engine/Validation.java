package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.Optional;

public class Validation {
    public Optional<Arithmetic> checkValid(String input) {
        if (input == null) return Optional.empty();

        String[] splitTokens = input.split("\\s");
        boolean checkNumeric = true;

        for (String splitToken : splitTokens) {
            if (checkNumeric) {
                checkNumeric = false;
                if (!RegularExpression.isNumeric(splitToken)) return Optional.empty();
            } else {
                checkNumeric = true;
                if (!RegularExpression.isOperator(splitToken)) return Optional.empty();
            }
        }
        if (checkNumeric) return Optional.empty();

        return Optional.of(new Arithmetic(splitTokens));
    }
}
