package com.example.cs495_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ButtonsController {
    @FXML
    private TextField equationInput;

    @FXML
    private Label error;

    @FXML
    private void handleEnter() {
        error.setText("Enter was pressed TEST");
        final String currentText = equationInput.getText();
        Pattern pattern = Pattern.compile("([0-3]+)\\W*([/*+-])\\W*([0-3]+)");
        Matcher matcher = pattern.matcher(currentText);
        if (matcher.find()) {
            final String operand = matcher.group(2);
            final String firstNumber = matcher.group(1);
            final String secondNumber = matcher.group(3);
            switch (operand) {
                case "+":
                    // Do add
                    break;
                case "-":
                    // Do subtract
                    break;
                case "/":
                    // Do divide
                    break;
                case "*":
                    // Do mult
                    break;
            }

        } else {
            System.out.println("We no found er");
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
}