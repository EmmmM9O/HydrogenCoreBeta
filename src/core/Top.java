package core;

import arc.graphics.Color;
import arc.util.Nullable;
import mindustry.graphics.Pal;

public class Top<T> {
    @Nullable
    public T data;
    public String name;
    public Color color= Pal.place;
    public Integer x,y;
    public Top(Integer xx,Integer yy,String n){
        x=xx;y=yy;name=n;
    }
}
