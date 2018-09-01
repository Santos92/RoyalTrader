package main;

import gui.Handler;
import gui.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;

public class RoyalTrader extends Application {

    public static int WIDTH = 300, HEIGHT = 400;
    public static String TITLE = "RoyalTrader";
    public static Stage window;
    public Scenes scenes;

    public Handler handler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize(primaryStage);

        window.setScene(scenes.mainMenu());

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initialize(Stage primaryStage) {
        window = primaryStage;
        window.setTitle(TITLE);
        handler = new Handler();
        scenes = new Scenes(handler);


    }
}
