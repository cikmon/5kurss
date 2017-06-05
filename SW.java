package sample;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cik on 05.06.2017.
 */
public class SW {
    private int WrazmerKorpusa ;
    private int HrazmerKorpusa ;
    private int LrazmerKorpusa ;
    private int ThicknessRrazmerKorpusa ;
    private ArrayList<String> macros;
    private Ploskosti[] ploskosti;
    int n;
    public SW(Ploskosti[] ploskosti,int n){
        this.ploskosti=ploskosti;
        this.n=n;
    }

    public void save(){

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT","*.*");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        if ( fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
            try ( FileWriter fw = new FileWriter(fc.getSelectedFile()) ) {
               /* fw.write("Widht Ploskost №1;Haight Ploskost №1;Widht Ploskost №2;Haight Ploskost №2;Widht Ploskost №3;Haight Ploskost №3;" +
                        "Widht Ploskost №4;Haight Ploskost №4;Widht Ploskost №5;Haight Ploskost №5;Widht Ploskost №6;Haight Ploskost №6 \r\n");
                fw.write(WrazmerPloskost1+";"+HrazmerPloskost1+";"+WrazmerPloskost1+";"+ HrazmerPloskost2+";"+ WrazmerPloskost3+";"+ HrazmerPloskost3+";"+
                        WrazmerPloskost4+";"+HrazmerPloskost4+";"+WrazmerPloskost5+";"+ HrazmerPloskost5+";"+ WrazmerPloskost6+";"+ HrazmerPloskost6+";"
                        + "\r\n");

                fw.write("Name;Width;Haight;Coord X;Coord Y;Ploskost;Ryadom;Angle;;;;\r\n");


                for(int i=0;i<ipl1;i++) {

                    String str = ploskost1[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost1[i].width() + ";" + ploskost1[i].haight() + ";" + ploskost1[i].coordX() + ";" + ploskost1[i].coordY() + ";"
                            + 0 + ";" + 0 + ";" + ploskost1[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl2;i++) {
                    String str = ploskost2[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost2[i].width() + ";" + ploskost2[i].haight() + ";" + ploskost2[i].coordX() + ";" + ploskost2[i].coordY() + ";"
                            + 1 + ";" + 0 + ";" + ploskost2[i].angle() + "\r\n");
                }
                for(int i=0;i<ipl3;i++) {
                    String str = ploskost3[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost3[i].width() + ";" + ploskost3[i].haight() + ";" + ploskost3[i].coordX() + ";" + ploskost3[i].coordY() + ";"
                            + 2 + ";" + 0 + ";" + ploskost3[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl4;i++) {
                    String str = ploskost4[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost4[i].width() + ";" + ploskost4[i].haight() + ";" + ploskost4[i].coordX() + ";" + ploskost4[i].coordY() + ";"
                            + 3 + ";" + 0 + ";" + ploskost4[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl5;i++) {
                    String str = ploskost5[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost5[i].width() + ";" + ploskost5[i].haight() + ";" + ploskost5[i].coordX() + ";" + ploskost5[i].coordY() + ";"
                            + 4 + ";" + 0 + ";" + ploskost5[i].angle() + "\r\n");
                }

                for(int i=0;i<ipl6;i++) {
                    String str = ploskost6[i].names();
                    String wsw = String.valueOf(str.charAt(1));
                    if (str.charAt(2) > 47 & str.charAt(2) < 58) {
                        wsw = wsw + String.valueOf(str.charAt(2));
                        if (str.charAt(3) > 47 & str.charAt(3) < 58) {
                            wsw = wsw + String.valueOf(str.charAt(3));
                        }
                    }
                    fw.write(wsw + ";" + ploskost6[i].width() + ";" + ploskost6[i].haight() + ";" + ploskost6[i].coordX() + ";" + ploskost6[i].coordY() + ";"
                            + 5 + ";" + 0 + ";" + ploskost6[i].angle() + "\r\n");
                }
*/
            }
            catch ( IOException e ) {
            }
        }







}

}
