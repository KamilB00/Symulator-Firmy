module symulator.firmy.v2 {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports symulator to javafx.graphics;
    opens symulator.gui to javafx.fxml;

}