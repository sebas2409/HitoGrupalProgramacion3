module com.example.hitogrupalprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires unirest.java;
    requires gson;
    requires json;


    opens com.example.hitogrupalprogramacion3 to javafx.fxml, gson;
    opens com.example.hitogrupalprogramacion3.models to gson;
    opens com.example.hitogrupalprogramacion3.services to gson;
    exports com.example.hitogrupalprogramacion3.models;
    exports com.example.hitogrupalprogramacion3;
}