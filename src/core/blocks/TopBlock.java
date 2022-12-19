package core.blocks;

import arc.Core;
import arc.graphics.Color;

import arc.math.geom.Vec2;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Nullable;
import core.Top;

import core.ui.tables.ItemSeletors;
import mindustry.content.Items;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.type.Item;
import mindustry.world.Block;
import mindustry.world.Tile;

import java.util.Vector;


public class TopBlock extends Block {


    public Vector<Top<Item>> tops=new Vector<>();
    public TopBlock(String name){

        super(name);
        configurable=true;
        update=true;

        tops.add(new Top<>(0,1,"up"));
        tops.add(new Top<>(0,-1,"down"));
        tops.add(new Top<>(1,0,"right"));
        tops.add(new Top<>(-1,0,"left"));

    }
    public class TopBuilding extends Building {
        @Override
        public void updateTableAlign(Table table) {
            Vec2 pos;
            if(nowTop==null) pos = Core.input.mouseScreen(this.x, this.y);
            else pos=Core.input.mouseScreen(this.x+ nowTop.x*-10f,this.y+ nowTop.y*8f);
            table.setPosition(pos.x, pos.y, 2);
        }

        @Override
        public Building init(Tile tile, Team team, boolean shouldAdd, int rotation) {
            TopList.add(Items.coal);
            TopList.add(Items.copper);
            return super.init(tile, team, shouldAdd, rotation);
        }

        @Override
        public void buildConfiguration(Table table) {
            TopUi.draw(table);
        }

        public Vector<Item> TopList=new Vector<>();

       public ItemSeletors TopUi=new ItemSeletors(){
           @Override
           public void chooseRun(Item item) {
               if (nowTop==null) return;
               nowTop.data=item;
               super.chooseRun(item);
           }
       };
        @Nullable
        public Top<Item> nowTop;
        @Override
        public void drawConfigure() {
            super.drawConfigure();
            for (var i:tops){
                Color c=i.color;
                if (nowTop!=null&& nowTop.x.equals(i.x) && nowTop.y.equals(i.y)) c= Pal.accent;
                Drawf.square(i.x*8+x,i.y*8+y,5f,c);
            }
        }

        @Override
        public void onConfigureClosed() {
            super.onConfigureClosed();
            nowTop=null;
        }

        @Override
        public boolean onConfigureTapped(float x, float y) {

            for (var i:tops){
                var len=Math.sqrt((x-this.x-i.x*8f)*(x-this.x-i.x*8f)+(y-this.y-i.y*8f)*(y-this.y-i.y*8f));
                Log.info(len);
                if(len<=5.5d){
                    nowTop=i;
                    Log.info(i.name);
                    TopUi.list=TopList;
                    return true;
                }
            }
            return false;
        }

    }
}
