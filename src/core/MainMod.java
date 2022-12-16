package core;

import arc.util.*;
import core.test.content;
import mindustry.mod.*;

public class MainMod extends Mod{

    public MainMod(){
        Log.info("hc beta load");

    }

    @Override
    public void loadContent(){
        Log.info("Loading");
        content.init();
    }

}
