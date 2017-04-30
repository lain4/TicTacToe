package entity;

/**
 * Created by lain on 22.04.2017.
 */
abstract class Entity {
    private int picks;
    private String name;

    public Entity(String name) {
        picks = 0;
        this.name = name;
    }

    final void reset() {
        picks = 0;
    }

    public final void choose(int n) {
        picks |= 1 << n;
    }

    public final int get() {
        return picks;
    }
}
