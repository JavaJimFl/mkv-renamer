module com.kaib.media.renamer {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.tinylog.api;
    requires org.apache.commons.lang3;

    exports com.kaib.media.renamer;
    opens com.kaib.media.renamer to javafx.fxml;
}
