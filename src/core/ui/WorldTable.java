package core.ui;

import arc.Core;
import arc.Events;
import arc.math.Interp;
import arc.math.geom.Vec2;
import arc.scene.Group;
import arc.scene.actions.Actions;
import arc.scene.ui.layout.Table;
import arc.scene.ui.layout.WidgetGroup;
import mindustry.Vars;
import mindustry.game.EventType;


public class WorldTable {
    private WidgetGroup group = new WidgetGroup();
    public void build(){

        table.visible = false;
        group.addChild(table);

        Events.on(EventType.ResetEvent.class, e -> forceHide());
    }
    public void forceHide(){
        table.visible = false;
        showB= false;
    }

    public boolean showB=true;
    public Table table=new Table();

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
        table.visible=true;
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
