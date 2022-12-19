package core.ui.tables;

import arc.graphics.Color;
import arc.scene.ui.layout.Table;
import core.ui.WorldTable;
import mindustry.gen.Icon;


public class Leach extends WorldTable {

    @Override
    public void draw(Table table) {
        table.setColor(Color.gray);
        table.add("Leach");

    }
}
