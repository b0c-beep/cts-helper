package ro.ase.csie.cts.flyweight.models;

import ro.ase.csie.cts.flyweight.abstracts.IRenderable;
import ro.ase.csie.cts.flyweight.enums.EnemyType;

import java.util.HashMap;
import java.util.Map;

public class EnemyFactory {
    private Map<EnemyType, IRenderable> enemies = new HashMap<>();

    public IRenderable getEnemy(EnemyType type) {
        if (!enemies.containsKey(type)) {
            IRenderable enemy = new Enemy3D(type, "orc_model", "orc_texture");
            enemies.put(type, enemy);
        }
        return enemies.get(type);
    }
}
