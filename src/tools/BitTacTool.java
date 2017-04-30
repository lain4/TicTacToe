package tools;

/**
 * Created by lain on 29.04.2017.
 */
public abstract class BitTacTool {
    private static final int ROW = 0b111;
    private static final int COL = 0b100100100;
    private static final int DIA = 0b100010001;
    private static final int DIA_2 = 0b001010100;

    public static int getBit(int n, int place) {
        return (n >> place) & 1;
    }

    public static int getOptions(int p1, int p2) {
        return ~(p1 | p2);
    }

    public static boolean turn(int p1, int p2) {
        return Integer.bitCount((p1 | p2)) % 2 == 0;
    }

    public static boolean allTaken(int p1, int p2) {
        return ~getOptions(p1, p2) == 0b111111111;
    }

    public static boolean hasWon(int picks) {
        return (picks & DIA) == DIA || (picks & DIA_2) == DIA_2 ||
                (picks & ROW) == ROW || (picks & ROW << 3) == ROW << 3 ||
                (picks & ROW << 6) == ROW << 6 ||
                (picks & COL) == COL || (picks & COL >> 1) == COL >> 1 ||
                (picks & COL >> 2) == COL >> 2;
    }
}
