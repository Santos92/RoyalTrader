package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

import static main.RoyalTrader.*;


public class Scenes implements EventHandler<ActionEvent> {

    public String buttonCss =
            "-fx-background-color: \n" +
                    "#090a0c,\n" +
                    "linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                    "linear-gradient(#20262b, #191d22),\n" +
                    "radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                    "-fx-background-radius: 5,4,3,5;\n" +
                    "-fx-background-insets: 0,1,2,0;\n" +
                    "-fx-text-fill: white;\n" +
                    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                    "-fx-font-family: \"Arial\";\n" +
                    "-fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                    "-fx-font-size: 12px;\n" +
                    "-fx-padding: 10 20 10 20;";
    public String backgroundColorCss = "-fx-background-color: #666666";


    public Handler handler;
    public Boxes boxes;

    public Scenes(Handler handler) {
        this.handler = handler;
        this.boxes = new Boxes();
    }

    public Scene mainMenu() {
        BorderPane borderPane = new BorderPane();
        StackPane topPane = new StackPane();
        VBox middlePane = new VBox();

        borderPane.setTop(topPane);
        borderPane.setCenter(middlePane);

        Text introText = new Text("Royal Trader");
        introText.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        introText.setFill(Color.valueOf("ffffff"));

        Button newGameButton = new Button("Login");
        Button loadGameButton = new Button("Register");
        Button optionsButton = new Button("Options");
        Button exitGame = new Button("Exit");

        ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(newGameButton, loadGameButton, optionsButton, exitGame));
        buttons.forEach(b -> {
            b.setPadding(new Insets(5));
            b.setPrefSize(100, 0);
            b.setStyle(buttonCss);
        });

        topPane.getChildren().add(introText);
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(20));
        topPane.setStyle(backgroundColorCss);

        middlePane.getChildren().addAll(buttons);
        middlePane.setAlignment(Pos.TOP_CENTER);
        middlePane.setStyle(backgroundColorCss);
        middlePane.setSpacing(20);
        middlePane.setPadding(new Insets(40, 0, 0, 0));

        newGameButton.setOnAction(this);
        exitGame.setOnAction(e -> {
            window.close();
            System.exit(0);
        });

        return new Scene(borderPane, WIDTH, HEIGHT);
    }

    public void handle(ActionEvent e) {
        boxes.loginBox();
    }


}
