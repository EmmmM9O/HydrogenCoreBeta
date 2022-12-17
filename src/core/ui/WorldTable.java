package core.ui;

import arc.Core;
import arc.math.Interp;
import arc.math.geom.Vec2;
import arc.scene.actions.Actions;
import arc.scene.ui.layout.Table;


public class WorldTable {
    public boolean showB=true;
    public Table table;

    public void MoveTo(float x,float y){
        Vec2 pos = Core.input.mouseScreen(x,y);
        table.setPosition(pos.x, pos.y, 2);
    }
    public void draw(){

    }
    public void close(){
        showB=false;
        table.actions(Actions.scaleTo(0f, 1f, 0.06f, Interp.pow3Out), Actions.visible(false));
    }
    public void showAt(float x,float y){
        table.clear();
        draw();
        table.pack();
        table.setTransform(true);
        table.actions(Actions.scaleTo(0f, 1f), Actions.visible(true),
                Actions.scaleTo(1f, 1f, 0.07f, Interp.pow3Out));

        table.update(() -> {
            if(showB){
                MoveTo(x,y);
            }else {
                close();
            }
        });
    }
}
