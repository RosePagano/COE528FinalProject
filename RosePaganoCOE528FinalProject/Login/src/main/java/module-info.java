module coe528.project.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens coe528.project.login to javafx.fxml;
    exports coe528.project.login;
}
