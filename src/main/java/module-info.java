module br.edu.ifsp.javafx.aulas {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.javafx.aulas to javafx.fxml;
    exports br.edu.ifsp.javafx.aulas;
    
    opens br.edu.ifsp.javafx.aulas.controller to javafx.fxml;
    exports br.edu.ifsp.javafx.aulas.controller;

    opens br.edu.ifsp.javafx.aulas.model to javafx.fxml;
    exports br.edu.ifsp.javafx.aulas.model;
}
