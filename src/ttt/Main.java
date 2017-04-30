package ttt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board(stage);
        stage.setTitle("TicTacToeFX");
        stage.setScene(new Scene(board));
        stage.show();
    }
}