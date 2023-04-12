module com.example.gamificationaccesa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.gamificationaccesa.controller to javafx.fxml;
    opens com.example.gamificationaccesa to javafx.fxml;

    exports com.example.gamificationaccesa.domain;
    exports com.example.gamificationaccesa.controller;
    exports com.example.gamificationaccesa;

}