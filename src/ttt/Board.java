package ttt;

import entity.Enemy;
import entity.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tools.BitTacTool;

import java.util.Optional;

/**
 * Created by lain on 22.04.2017.
 */
public class Board extends GridPane {
    private Player you;
    private Enemy en;
    private Stage stage;

    Board(Stage stage) {
        you = new Player("Mii");
        en = new Enemy("Andou");
        this.stage = stage;
        init();
    }

    private void init() {

        //LAYOUT
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setVgap(10);
        this.setHgap(10);


        //LOAD CELLS
        for (int i = 9, col = 0, row = 0; i >= 0; i--, col++) {

            if (i != 9) {
                Cell c = new Cell(i);

                //ASSIGN ACTIONs
                c.setOnMouseClicked(e -> {
                    if (!c.isClaimed()) {
                        c.setValue(BitTacTool.turn(you.get(), en.get()));
                    }
                    register(c.getIndex());
                    if (BitTacTool.hasWon(you.get()))
                        showEnd("X won!");
                    else if (BitTacTool.hasWon(en.get()))
                        showEnd("O won!");
                    else if (BitTacTool.allTaken(you.get(), en.get()))
                        showEnd("GG! DRAW");
                });

                this.add(c, row, col);
            }
            if (i % 3 == 0) {
                row++;
                col = 0;
            }
        }
    }

    private void register(int n) {
        if (BitTacTool.turn(you.get(), en.get()))
            you.choose(n);
        else
            en.choose(n);
    }

    private void showEnd(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EndScreen");
        alert.setHeaderText(s);
        alert.setContentText("Stats and trashtalk");

        ButtonType rematch = new ButtonType("Rematch");
        ButtonType exit = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(rematch, exit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == rematch)
            stage.setScene(new Scene(new Board(stage)));
        else
            stage.close();

    }

}
