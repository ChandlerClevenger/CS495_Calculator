module com.example.cs495_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs495_calculator to javafx.fxml;
    exports com.example.cs495_calculator;
}