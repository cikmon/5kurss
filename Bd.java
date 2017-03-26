package sample;
public class Bd {
    private String names;
    private int haight;
    private int width;
    private int coordX;
    private int coordY;
    private int ploskost;
    private int ryadom;
    private int angle;
    private int angleY;

    public Bd(String names,int width, int haight,int coordX,int coordY,int ploskost,int ryadom, int angle){
        this.width=width;
        this.haight=haight;
        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.ploskost=ploskost;
        this.ryadom=ryadom;
        this.angle=angle;

    }
    public double perimetr(){
     return width+haight+coordX+coordY;
    }
    public String names(){
        return names;
    }
    public int haight(){
        return haight;
    }
    public int width(){return width;}
    public int coordX(){
        return coordX;
    }
    public int coordY(){
        return coordY;
    }
    public int ploskost(){
        return ploskost;
    }
    public int ryadom(){return  ryadom;}
    public int angle(){return  angle;}

}