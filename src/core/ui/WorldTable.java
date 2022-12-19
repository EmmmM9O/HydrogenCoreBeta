package core.ui;

import arc.scene.ui.layout.Table;
import mindustry.gen.Tex;


public class WorldTable {
    public String name="none";
    public float wide=200f;
    public float high=150f;
    public void get(Table table){
        table.table(Tex.pane,(table1 -> table1.add(name))).size(wide,20).row();
        table.table(Tex.pane,(table1 ->
            table1.pane(this::draw).size(wide,high-20f)
        )).size(wide,high-20f);
    }
    public void draw(Table table){

    }

}
