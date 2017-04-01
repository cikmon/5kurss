package sample;

public class Ploskosti {


    private String names;
    private double coordX;
    private double coordY;
    private double coordZ;

    private int haight;
    private int width;
    private int lenght;

    private int angleX;
    private int angleY;
    private int angleZ;


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
    private double tochka1[]=new double[3];
    private double tochka2[]=new double[3];
    private double tochka3[]=new double[3];
    private double tochka4[]=new double[3];
    private double tochka5[]=new double[3];
    private double tochka6[]=new double[3];
    private double tochka7[]=new double[3];
    private double tochka8[]=new double[3];




    public Ploskosti(
            String names,int width, int haight,int lenght, double coordX, double coordY,double coordZ,
            int angleX,int angleY,int angleZ){
        this.names=names;
        this.coordX=coordX;
        this.coordY=coordY;
        this.coordZ=coordZ;
        this.angleX=angleX;
        this.angleY=angleY;
        this.angleY=angleZ;

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

    public double coordX(){return coordX;}
    public double coordY(){return coordY;}
    public double coordZ(){return coordZ;}
    public int angleX(){return angleX;}
    public int angleY(){return angleY;}
    public int angleZ(){return angleY;}
    public String names(){return names;}

    public short pixels(int i, int j){return pixels[i][j];}
    public short pixels2(int i, int j){return pixels2[i][j];}
    public short pixels3(int i, int j){return pixels3[i][j];}
    public short pixels4(int i, int j){return pixels4[i][j];}
    public short pixels5(int i, int j){return pixels5[i][j];}
    public short pixels6(int i, int j){return pixels6[i][j];}

    public int haight(){
        return haight;
    }
    public int width(){return width;}
    public int lenght(){return lenght;}

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

    public void osntochkidobavl(double[] t1,double[] t6,double[] t2,double[] t3,double[] t4,double[] t5,double[] t7,double[] t8){
        this.tochka1=t1;this.tochka2=t2;this.tochka3=t3;this.tochka4=t4;
        this.tochka5=t5;this.tochka6=t6;this.tochka7=t7;this.tochka8=t8;
    }
    public double poluchtochka1(int i){return tochka1[i];}
    public double poluchtochka2(int i){return tochka2[i];}
    public double poluchtochka3(int i){return tochka3[i];}
    public double poluchtochka4(int i){return tochka4[i];}
    public double poluchtochka5(int i){return tochka5[i];}
    public double poluchtochka6(int i){return tochka6[i];}
    public double poluchtochka7(int i){return tochka7[i];}
    public double poluchtochka8(int i){return tochka8[i];}




}
