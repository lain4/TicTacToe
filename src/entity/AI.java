package entity;

import tools.BitTacTool;

import java.util.List;

/**
 * Created by lain on 24.04.2017.
 */
public class AI extends Entity {
    List<Integer> sequence;
    private int p1 = 0, p2 = 0;


    public AI(String name) {
        super(name);
    }


    private int[] sequence() {

        if (BitTacTool.getOptions(p1, p2) != 0) {

        }
        return new int[3];
    }


    private void move() {
        if (!BitTacTool.turn(p1, p2)) {

        }
    }


}
