package tools;

/**
 * Created by lain on 29.04.2017.
 */
public abstract class BitTacTool {
    private static final int ROW = 0b111;
    private static final int COL = 0b100100100;
    private static final int DIA = 0b100010001;
    private static final int DIA_2 = 0b001010100;

    private static int getBit(int n, int place) {
        return (n >> place) & 1;
    }

    private static int getP1(int board) {
        return board >> 9;
    }

    private static int getP2(int board) {
        return board ^ (getP1(board) << 9);
    }

    public static int[] getLegals(int board) {
        int[] legals = new int[9 - Integer.bitCount(turn(board) ? getP1(board) : getP2(board))];
        for (int i = 0, idx = 0; i < 9; i++) {
            if (getBit(turn(board) ? getP1(board) : getP2(board), i) == 0)
                legals[idx++] = i;
        }
        return legals;
    }

    public static boolean turn(int board) {
        return Integer.bitCount((getP1(board) | getP2(board))) % 2 == 0;
    }

    public static boolean allTaken(int board) {
        return (getP1(board) | getP2(board)) == 0b111111111;
    }

    private static boolean hasWon(int picks) {
        return (picks & DIA) == DIA || (picks & DIA_2) == DIA_2 ||
                (picks & ROW) == ROW || (picks & ROW << 3) == ROW << 3 ||
                (picks & ROW << 6) == ROW << 6 ||
                (picks & COL) == COL || (picks & COL >> 1) == COL >> 1 ||
                (picks & COL >> 2) == COL >> 2;
    }

    public static boolean p2Won(int board) {
        return hasWon(getP2(board));
    }

    public static boolean p1Won(int board) {
        return hasWon(getP1(board));
    }
}
