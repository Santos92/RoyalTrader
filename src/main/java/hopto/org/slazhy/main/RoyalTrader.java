package hopto.org.slazhy.main;

import hopto.org.slazhy.data.Player;
import hopto.org.slazhy.gui.Handler;
import hopto.org.slazhy.gui.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hopto.org.slazhy.service.PlayerService;

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
        new Thread(this::setupDatabase).start();
        window = primaryStage;
        window.setTitle(TITLE);
        handler = new Handler();
        scenes = new Scenes(handler);


    }

    private void setupDatabase() {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("hopto.org.slazhy");
            context.refresh();

            PlayerService service = context.getBean(PlayerService.class);
            service.addPlayer(new Player("123", "321"));


        }
    }
}
