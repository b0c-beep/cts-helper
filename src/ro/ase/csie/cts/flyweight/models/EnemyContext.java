package ro.ase.csie.cts.flyweight.models;

public class EnemyContext {
    private int x;
    private int y;
    private float hp;

    public EnemyContext() {
    }

    public EnemyContext(int x, int y, float hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
}
