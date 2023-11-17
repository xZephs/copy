module org.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens org.javafx to javafx.fxml;
    exports org.javafx;
}
