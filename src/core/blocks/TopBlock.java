package core.blocks;

import arc.graphics.Color;

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

    public Top[] tops={new Top(0,1,"up"),new Top(0,-1,"down")
    ,new Top(1,0,"right"),new Top(-1,0,"left")};

    public TopBlock(String name){
        super(name);
        configurable=true;
        update=true;
    }
    public class TopBuilding extends Building {
        @Override
        public Building init(Tile tile, Team team, boolean shouldAdd, int rotation) {
            TopList.add(Items.coal);
            TopList.add(Items.copper);
            TopUi.build();
            return super.init(tile, team, shouldAdd, rotation);
        }

        public Vector<Item> TopList=new Vector<>();

       public ItemSeletors TopUi=new ItemSeletors(){
           @Override
           public void chooseRun(Item item) {

               super.chooseRun(item);
           }
       };
        @Nullable
        public Top nowTop;
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
                    TopUi.showAt(x-16f,y);
                    TopUi.showB=true;
                    return true;
                }
            }
            TopUi.showB=false;
            return false;
        }

    }
}
