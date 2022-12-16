package core.blocks;

import arc.util.Log;
import core.Top;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.world.Block;

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
        public void drawConfigure() {
            super.drawConfigure();
            for (var i:tops){
                Drawf.square(i.x*8+x,i.y*8+y,5f,i.color);
            }
        }

        @Override
        public boolean onConfigureTapped(float x, float y) {

            for (var i:tops){
                var len=Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
                if(len<=5.5d){
                    Log.info(i.name);
                    return false;
                }
            }
            return false;
        }
    }
}
