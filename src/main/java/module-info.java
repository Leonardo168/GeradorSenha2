module com.geradorsenha2.temp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.geradorsenha2.geradorsenha2 to javafx.fxml;
    exports com.geradorsenha2.geradorsenha2;
}