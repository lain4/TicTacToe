package entity;

import tools.BitTacTool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by lain on 24.04.2017.
 */
public class AI extends Entity {
    private int board;

    public AI(String name) {
        super(name);
    }


    public final void sequence() {
        List<Integer> test = new LinkedList<>();
        board = 0;
        int[] moves;

        while ((!BitTacTool.allTaken(board) &&
                !BitTacTool.p1Won(board) &&
                !BitTacTool.p2Won(board))) {
            moves = BitTacTool.getLegals(board);
            register(moves[new Random().nextInt(moves.length)]);
            test.add(board);
        }
        for (int x : test)
            System.out.println(Integer.toBinaryString(x));
    }

    private void register(int n) {
        if (BitTacTool.turn(board))
            board |= (1 << (n + 9));
        else
            board |= (1 << n);
    }

    private void move() {

    }

}
