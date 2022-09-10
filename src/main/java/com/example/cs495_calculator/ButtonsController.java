package com.example.cs495_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import methods.Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ButtonsController {
    final Function arithmeticLogic = new Function();
    private boolean isCNVT = false;
    @FXML
    private TextField equationInput;

    @FXML
    private Label error;

    @FXML
    private void handleEnter() {
        if (checkIsCNVT()) {return;}
        final String currentText = equationInput.getText();
        Pattern pattern = Pattern.compile("([0-3]+)\\W*([/*+-])\\W*([0-3]+)");
        Matcher matcher = pattern.matcher(currentText);
        if (!matcher.find()) { error.setText("Please enter a valid expression."); return; }

        int result = 0;
        try {
            final String operand = matcher.group(2);
            final int firstNumber = Integer.parseInt(matcher.group(1));
            final int secondNumber = Integer.parseInt(matcher.group(3));
            switch (operand) {
                case "+":
                    result = arithmeticLogic.add(firstNumber, secondNumber);
                    break;
                case "-":
                    if (firstNumber < secondNumber) {
                        error.setText("We don't have to handle negatives.");
                        return;
                    }
                    result = arithmeticLogic.subtract(firstNumber, secondNumber);
                    break;
                case "/":
                    if(secondNumber == 0){
                        error.setText("Divide by 0 error");
                        equationInput.clear();
                    }else{
                        result = arithmeticLogic.divide(firstNumber, secondNumber);
                        break;
                    }
                case "*":
                    result = arithmeticLogic.multiply(firstNumber, secondNumber);
                    break;
            }
        } catch (NumberFormatException e) {
            error.setText("Entered numbers or result is too large.");
            return;
        }

        equationInput.setText(
                String.valueOf(result)
        );
    }

    @FXML
    protected void addSymbol(String s) {
        if (checkIsCNVT()) {return;}
        final String currentText = equationInput.getText();
        if (!isOnlyDigits() && isOperand(s)) {
            error.setText("You must enter digits first, then operator");
            return;
        }
        if (isSymbol(currentText) && isOperand(s)){
            error.setText("Only one operand allowed.");
            return;
        }
        equationInput.setText(currentText + s);
    }


    @FXML
    private void handle0() {
        addSymbol("0");
    }
    @FXML
    private void handle1() {
        addSymbol("1");
    }
    @FXML
    private void handle2() {
        addSymbol("2");
    }
    @FXML
    private void handle3() {
        addSymbol("3");
    }
    @FXML
    private void handlePlus() {
        addSymbol(" + ");
    }
    @FXML
    private void handleSub() {
        addSymbol(" - ");
    }
    @FXML
    private void handleMult() {
        addSymbol(" * ");
    }
    @FXML
    private void handleDiv() {
        addSymbol(" / ");
    }
    @FXML
    private void handleSqr() {
        if (checkIsCNVT()) {return;}
        error.setText("");
        final String number = equationInput.getText();
        if(!isOnlyDigits()) {
            error.setText("You must only have digits to square");
            return;
        }
        try {
            equationInput.setText(String.valueOf(arithmeticLogic.square(Integer.parseInt(number))));
        } catch (NumberFormatException e) {
            error.setText("Result is too big");
        }
    }
    @FXML
    private void handleSqrt() {
        if (checkIsCNVT()) {return;}
        error.setText("");
        final String number = equationInput.getText();
        if(!isOnlyDigits()) {
            error.setText("You must only have digits to square root");
            return;
        }
        equationInput.setText(String.valueOf(arithmeticLogic.squareRoot(Integer.parseInt(number))));
    }

    @FXML
    private void handleClear() {
        isCNVT = false;
        error.setText("");
        equationInput.setText("");
    }
    @FXML
    private void handleCNVT() {
        final int converted;
        if (!isOnlyDigits()) {
            error.setText("You must have only digits to convert!");
            return;
        }
        if (isCNVT) {
            converted = arithmeticLogic.decimalToQuaternary(Integer.parseInt(equationInput.getText()));
        } else {
            converted = arithmeticLogic.quaternaryToDecimal(Integer.parseInt(equationInput.getText()));
        }
        equationInput.setText(String.valueOf(converted));
        isCNVT = !isCNVT;
    }

    private boolean checkIsCNVT() {
        error.setText("");
        if (isCNVT) {
            error.setText("You must un-convert or erase to continue.");
        }
        return isCNVT;
    }

    private boolean isOnlyDigits() {
        final String s = equationInput.getText();
        return Pattern.compile("^\\d+$").matcher(s).find();
    }

    private boolean isOperand(String s) {
        return (s.equals(" + ") || s.equals(" / ") || s.equals(" - ") || s.equals(" * "));
    }

    private boolean isSymbol(String s) {
        return Pattern.compile("[/*+-]").matcher(s).find();
    }
}