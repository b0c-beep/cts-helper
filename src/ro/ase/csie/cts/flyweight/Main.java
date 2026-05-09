package ro.ase.csie.cts.flyweight;

import ro.ase.csie.cts.flyweight.abstracts.IRenderable;
import ro.ase.csie.cts.flyweight.enums.EnemyType;
import ro.ase.csie.cts.flyweight.models.EnemyContext;
import ro.ase.csie.cts.flyweight.models.EnemyFactory;

public class Main {
    public static void main(String[] args) {
        EnemyFactory factory = new EnemyFactory();
        IRenderable enemy1 = factory.getEnemy(EnemyType.ORC);
        IRenderable enemy2 = factory.getEnemy(EnemyType.HOUND);
        IRenderable enemy3 = factory.getEnemy(EnemyType.TROLL);

        enemy1.render(new EnemyContext(100, 200, 100));
        enemy2.render(new EnemyContext(0, 50, 24));
        enemy3.render(new EnemyContext(430, 230, 200));
    }
}
