package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Boxes {

    public void loginBox() {
        // window setup
        Stage loginWindow = new Stage();
        loginWindow.setTitle("Login or register");
        loginWindow.initModality(Modality.APPLICATION_MODAL);

        // GridPane setup
        GridPane box = new GridPane();
        box.setPadding(new Insets(10));
        box.setVgap(8);
        box.setHgap(10);

        //Username label
        Label usernameLabel = new Label("username: ");
        GridPane.setConstraints(usernameLabel, 0, 0);

        //Username field
        TextField usernameField = new TextField("type your username");
        GridPane.setConstraints(usernameField, 1, 0, 2, 1);

        //Password label
        Label passwordLabel = new Label("password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);

        //Password field
        TextField passwordField = new TextField();
        GridPane.setConstraints(passwordField, 1, 1, 2, 1);
        passwordField.setPromptText("password");

        //Buttons
        Button register = new Button("Register");
        GridPane.setConstraints(register, 0, 2);
        Button login = new Button("Login");
        GridPane.setConstraints(login, 1, 2);
        Button cancel = new Button("Cancel");
        GridPane.setConstraints(cancel, 2, 2);

        box.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, register, login, cancel);
        box.setAlignment(Pos.CENTER);

        Scene logRegScene = new Scene(box, 250, 150);

        loginWindow.setScene(logRegScene);
        loginWindow.show();
    }

    public void alertBox(String title, String message){
        Stage alertBox = new Stage();
        alertBox.setTitle(title);
        alertBox.initModality(Modality.APPLICATION_MODAL);

        VBox box = new VBox();
        box.setPadding(new Insets(5));

        Label textMessage = new Label(message);
        textMessage.setWrapText(true);
        textMessage.setPadding(new Insets(5,5,15,5));

        Button confirm = new Button("Confirm");
        confirm.setOnAction(e -> alertBox.close());

        box.getChildren().addAll(textMessage, confirm);
        box.setAlignment(Pos.CENTER);

        Scene alertScene = new Scene(box,250, 100);

        alertBox.setScene(alertScene);
        alertBox.showAndWait();

    }

}
