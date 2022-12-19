package core.ui.tables;

import arc.scene.ui.layout.Table;
import core.ui.WorldTable;

import mindustry.type.Item;

import java.util.Vector;

public class ItemSeletors extends WorldTable {
    public String name="ItemSeletors";
    public Vector<Item> list=new Vector<>();

    public void chooseRun(Item item){

    }

    @Override

    public void draw(Table table){
        for (var i:list){
            table.image(i.fullIcon).size(25f,25f);
            table.button("X",()->chooseRun(i)).size(25f,25f);
        }
    }

}
