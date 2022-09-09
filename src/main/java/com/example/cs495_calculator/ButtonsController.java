package com.example.cs495_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import methods.Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ButtonsController {
    final Function arithmeticLogic = new Function();
    @FXML
    private TextField equationInput;

    @FXML
    private Label error;

    @FXML
    private void handleEnter() {
        final String currentText = equationInput.getText();
        Pattern pattern = Pattern.compile("([0-3]+)\\W*([/*+-])\\W*([0-3]+)");
        Matcher matcher = pattern.matcher(currentText);
        if (!matcher.find()) { error.setText("Please enter a valid expression."); return; }

        final String operand = matcher.group(2);
        final int firstNumber = parseToDecimal(matcher.group(1));
        final int secondNumber = parseToDecimal(matcher.group(3));

        switch (operand) {
            case "+":
                // Do add
                final int added = arithmeticLogic.add(firstNumber, secondNumber);
                equationInput.setText(
                        String.valueOf(arithmeticLogic.decimalToQuaternary(added))
                );
                break;
            case "-":
                if (firstNumber < secondNumber) {
                    error.setText("We don't have to handle negatives.");
                    return;
                }
                // Do subtract
                final int subtracted = arithmeticLogic.subtract(firstNumber, secondNumber);
                equationInput.setText(
                        String.valueOf(arithmeticLogic.decimalToQuaternary(subtracted))
                );
                break;
            case "/":
                // Do divide
                if(secondNumber == 0){
                    error.setText("Divide by 0 error");
                    equationInput.clear();
                }else {
                    final int divided = arithmeticLogic.divide(firstNumber, secondNumber);
                    equationInput.setText(
                            String.valueOf(arithmeticLogic.decimalToQuaternary(divided))
                    );
                    break;
                }
            case "*":
                // Do mult
                final int multiplied = arithmeticLogic.multiply(firstNumber, secondNumber);
                equationInput.setText(
                        String.valueOf(arithmeticLogic.decimalToQuaternary(multiplied))
                );
                break;
        }
    }

    @FXML
    protected void addSymbol(String s) {
        // We can write a lot of checks on the equation string here
        // such as Integet.MAX_SIZE ~ or such
        // and disable buttons if a operand is already selected
        error.setText("");
        final String currentText = equationInput.getText();
        if (isSymbol(currentText) && (
                s.equals(" + ") || s.equals(" / ") || s.equals(" - ") || s.equals(" * ")
                )){
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

    private boolean isSymbol(String s) {
        Pattern pattern = Pattern.compile("[/*+-]");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    private int parseToDecimal(String qua) {
        return arithmeticLogic.quaternaryToDecimal(Integer.parseInt(qua));
    }
}