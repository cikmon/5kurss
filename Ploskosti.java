package sample;

import java.util.ArrayList;

public class Ploskosti {
    private int coordX;
    private int coordY;
    private int[][] pixels=new int[3][200000];
    private String names;
    private int angleX;
    private int angleY;
    private int angleZ;
    private int haight;
    private int width;
    private int length1;


    public Ploskosti(

            String names, int coordX,int coordY,int angle,
                     int width, int haight){


        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.angleX=angle;
        this.width=width;
        this.haight=haight;

    }

    public int coordX(){return coordX;}
    public int coordY(){return coordY;}
    public int angle(){return angleX;}
    public String names(){return names;}
    public int pixels(int i, int j){
        return pixels[i][j];

    }
    public int haight(){
        return haight;
    }
    public int width(){return width;}
    public int length1(){return length1;}
    public void dobavlpixels(int pixelX,int pixelY,int i,int length1){
        this.pixels[0][i]=pixelX;
        this.pixels[1][i]=pixelY;
      //  this.pixels[2][i]=pixelZ;
        this.length1=length1;
    }
}
