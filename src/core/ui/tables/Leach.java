package core.ui.tables;

import arc.graphics.Color;
import arc.scene.ui.layout.Table;
import arc.util.Nullable;
import core.ui.WorldTable;

import java.util.Vector;


public class Leach extends WorldTable {
    public Vector<WorldTable> paper=new Vector<>();
    @Nullable
    public WorldTable now;

    @Override
    public void draw(Table table) {
        table.setColor(Color.gray);
        table.add("Leach");
        for (var i:paper){
            table.button(i.name,()->now=i);
        }
        if(now==null)return;
        table.pane(t->{
            t.add(now.name);
            now.draw(t);
        });
    }
}
