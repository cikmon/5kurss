package sample;

public class Ploskosti {


    private String names;
    private short coordX;
    private short coordY;
    private short coordZ;

    private short haight;
    private short width;
    private short lenght;

    private short angleX;
    private short angleY;
    private short angleZ;


    private short[][] pixels;
    private short[][] pixels2;
    private short[][] pixels3;
    private short[][] pixels4;
    private short[][] pixels5;
    private short[][] pixels6;

    private short lengthpix;
    private short lengthpix2;
    private short lengthpix3;
    private short lengthpix4;
    private short lengthpix5;
    private short lengthpix6;

    //0x;1y;2z
    private short tochka1[]=new short[3];
    private short tochka2[]=new short[3];
    private short tochka3[]=new short[3];
    private short tochka4[]=new short[3];
    private short tochka5[]=new short[3];
    private short tochka6[]=new short[3];
    private short tochka7[]=new short[3];
    private short tochka8[]=new short[3];




    public Ploskosti(
            String names,short width, short haight,short lenght, short coordX, short coordY,short coordZ,
            short angleX,short angleY,short angleZ){
        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.coordZ=coordZ;
        this.angleX=angleX;
        this.angleY=angleY;
        this.angleZ=angleZ;
        this.width=width;
        this.haight=haight;
        this.lenght=lenght;

        pixels=new short[3][haight*width*3/9];
        pixels2=new short[3][haight*lenght*3/9];
        pixels3=new short[3][haight*lenght*3/9];
        pixels4=new short[3][lenght*width*3/9];
        pixels5=new short[3][lenght*width*3/9];
        pixels6=new short[3][haight*width*3/9];


    }

    public short coordX(){return coordX;}
    public short coordY(){return coordY;}
    public short coordZ(){return coordZ;}
    public short angleX(){return angleX;}
    public short anglY(){return angleY;}
    public short angleZ(){return angleZ;}
    public String names(){return names;}

    public short pixels(int i, int j){return pixels[i][j];}
    public short pixels2(int i, int j){return pixels2[i][j];}
    public short pixels3(int i, int j){return pixels3[i][j];}
    public short pixels4(int i, int j){return pixels4[i][j];}
    public short pixels5(int i, int j){return pixels5[i][j];}
    public short pixels6(int i, int j){return pixels6[i][j];}

    public short haight(){
        return haight;
    }
    public short width(){return width;}
    public short lenght(){return lenght;}

    public short lengthpix(){return lengthpix;}
    public short lengthpix2(){return lengthpix2;}
    public short lengthpix3(){return lengthpix3;}
    public short lengthpix4(){return lengthpix4;}
    public short lengthpix5(){return lengthpix5;}
    public short lengthpix6(){return lengthpix6;}


    public void dobavlpixels(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels[0][i]=pixelX;
        this.pixels[1][i]=pixelY;
        this.pixels[2][i]=pixelZ;
        this.lengthpix=(short)(i+1);
    }
    public void dobavlpixels6(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels6[0][i]=pixelX;
        this.pixels6[1][i]=pixelY;
        this.pixels6[2][i]=pixelZ;
        this.lengthpix6=(short)(i+1);
    }
    public void dobavlpixels2(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels2[0][i]=pixelX;
        this.pixels2[1][i]=pixelY;
        this.pixels2[2][i]=pixelZ;
        this.lengthpix2=(short)(i+1);
    }
    public void dobavlpixels3(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels3[0][i]=pixelX;
        this.pixels3[1][i]=pixelY;
        this.pixels3[2][i]=pixelZ;
        this.lengthpix3=(short)(i+1);
    }
    public void dobavlpixels4(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels4[0][i]=pixelX;
        this.pixels4[1][i]=pixelY;
        this.pixels4[2][i]=pixelZ;
        this.lengthpix4=(short)(i+1);
    }
    public void dobavlpixels5(short pixelX,short pixelY,short pixelZ,int i){
        this.pixels5[0][i]=pixelX;
        this.pixels5[1][i]=pixelY;
        this.pixels5[2][i]=pixelZ;
        this.lengthpix5=(short)(i+1);
    }

    public void osntochkidobavl(short[] t1,short[] t6,short[] t2,short[] t3,short[] t4,short[] t5,short[] t7,short[] t8){
        this.tochka1=t1;this.tochka2=t2;this.tochka3=t3;this.tochka4=t4;
        this.tochka5=t5;this.tochka6=t6;this.tochka7=t7;this.tochka8=t8;
    }
    public short poluchtochka1(int i){return tochka1[i];}
    public short poluchtochka2(int i){return tochka2[i];}
    public short poluchtochka3(int i){return tochka3[i];}
    public short poluchtochka4(int i){return tochka4[i];}
    public short poluchtochka5(int i){return tochka5[i];}
    public short poluchtochka6(int i){return tochka6[i];}
    public short poluchtochka7(int i){return tochka7[i];}
    public short poluchtochka8(int i){return tochka8[i];}




}
