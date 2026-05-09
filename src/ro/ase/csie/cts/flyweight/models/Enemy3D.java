package ro.ase.csie.cts.flyweight.models;

import ro.ase.csie.cts.flyweight.abstracts.IRenderable;
import ro.ase.csie.cts.flyweight.enums.EnemyType;

public class Enemy3D implements IRenderable {
    private EnemyType type;
    private String modelFile;
    private String textureFile;

    public Enemy3D(EnemyType type, String modelFile, String textureFile) {
        this.type = type;
        this.modelFile = modelFile;
        this.textureFile = textureFile;
    }


    @Override
    public void render(EnemyContext context) {
        System.out.println("RENDERING: " + type.toString() + " with texture "
                + textureFile + " at coords: x=" + context.getX() + ", y=" + context.getY()
                + " with HP=" + context.getHp());
    }
}
