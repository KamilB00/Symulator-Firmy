module symulator.firmy.v2 {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    exports symulator to javafx.graphics;
    opens symulator.gui to javafx.fxml;
}