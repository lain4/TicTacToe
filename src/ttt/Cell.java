package ttt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * Created by lain on 22.04.2017.
 */
public class Cell extends HBox {
    private StringProperty val;
    private boolean claimed;
    private int idx;

    Cell(int idx) {
        this.idx = idx;
        claimed = false;
        val = new SimpleStringProperty("");
        Label label = new Label();
        label.textProperty().bind(val);
        label.setFont(Font.font("SansSerif", FontWeight.BOLD, 70));
        label.setTextAlignment(TextAlignment.CENTER);

        this.setPrefSize(100, 100);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(label);
    }

    final String getValue() {
        return val.getValueSafe();
    }

    final void setValue(boolean turn) {
        claimed = true;
        val.set(turn ? "X" : "O");
    }

    final int getIndex() {
        return idx;
    }

    final boolean isClaimed() {
        return claimed;
    }


}
