module com.example.math {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.math to javafx.fxml;
    exports com.example.math;
}