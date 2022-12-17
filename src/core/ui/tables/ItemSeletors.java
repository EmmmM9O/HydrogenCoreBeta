package core.ui.tables;

import core.ui.WorldTable;
import mindustry.type.Item;

import java.util.Vector;

public class ItemSeletors extends WorldTable {

    public Vector<Item> list=new Vector<>();

    public void chooseRun(Item item){

    }
    public void draw(){
        table.pane((t ->{
            int row=0;
            for (var i:list){
                row++;

                t.image(i.fullIcon);
                t.button("X",()->chooseRun(i));
                if(row>=7) t.row();
            }
        }));
    }
}
