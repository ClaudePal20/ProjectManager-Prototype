module org.example.bibliotecadecodigopmi {
    requires javafx.controls;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires mpxj;
    requires javafx.web;
    requires javafx.fxml;

    opens org.example.bibliotecadecodigopmi.scrumlibrary to javafx.base; // Agregada esta línea
    exports org.example.bibliotecadecodigopmi.gui;
    exports org.example.bibliotecadecodigopmi.scrumlibrary;
}
