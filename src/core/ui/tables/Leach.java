package core.ui.tables;


import arc.graphics.Color;
import arc.scene.ui.layout.Table;

import core.ui.WorldTable;
import mindustry.gen.Tex;
import mindustry.type.Item;
import mindustry.type.Liquid;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;


public class Leach extends WorldTable {
    public Vector<Item> items=new Vector<>();
    public Vector<Liquid> liquids=new Vector<>();
    public Map<Item,Boolean> CItem=new HashMap<>();
    public Map<Liquid,Boolean> CLiquid=new HashMap<>();


    public String now="none";
    public float high=200;


    @Override
    public void draw(Table table) {
        table.table(Tex.pane,t-> {
            var k1 = t.button("Item", () -> now = "Item").size(80f, 20f);
            var k2 = t.button("Liquids", () -> now = "Liquid").size(80f, 20f);
            if (Objects.equals(now, "Item")) k1.color(Color.orange);
            if (Objects.equals(now, "Liquid")) k2.color(Color.orange);
        }).size(wide,20f);
        table.table(Tex.pane,t->{
            if (Objects.equals(now, "Item")){
                for (var i:items){
                    t.image(i.fullIcon).size(25f,25f);
                    if (CItem.containsKey(i)||!CItem.get(i)) t.button("X",()->CItem.put(i,true)).size(25f,25f);
                    else t.button("O",()->CItem.put(i,false)).size(25f,25f);

                }
            } else if (Objects.equals(now,"Liquid")) {
                for (var i:liquids){
                    t.image(i.fullIcon).size(25f,25f);
                    if (CLiquid.containsKey(i)||!CLiquid.get(i)) t.button("X",()->CLiquid.put(i,true)).size(25f,25f);
                    else t.button("O",()->CLiquid.put(i,false)).size(25f,25f);

                }
            }
        }).size(wide,high-40f);
    }
}
