package core.test;

import core.blocks.TopBlock;
import mindustry.content.Items;
import mindustry.type.Category;


import static mindustry.type.ItemStack.with;

public class content {
    public static TopBlock test1;
    public static void init(){

        test1=new TopBlock("test1"){{
            requirements(Category.logic, with(Items.graphite, 5,Items.copper, 5));
        }};


    }
}
