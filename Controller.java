package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Arrays;

public class Controller {
    public TextField namesform;
    public TextField widthform;
    public TextField haightform;
    public ComboBox<String> combobox1;
    public ComboBox<String> combobox2;
    public ComboBox<String> combobox3;
    public ComboBox<String> combobox4;
    public TextField coordYform;
    public TextField coordXform;
    public TextField angleform;

    private int WrazmerKorpusa = 0;
    private int HrazmerKorpusa = 0;
    private int LrazmerKorpusa = 0;
    private int ThicknessRrazmerKorpusa = 0;

    private Bd[] bd;
    private Ploskosti[] osnovnoi;
    private Ploskosti[] ryadom;
    private Ploskosti[] ostalnie;


    private int kolvosnaclonom = 0;

    int n = 0;
    int n12 = 0;
    int ploskost = 0;
    int ploskostpostr = 0;


    private JFXPanel primaryStage;
    private ObservableList<String> list = FXCollections.observableArrayList("Cоздание обьекта №1");
    private ObservableList<String> list2 = FXCollections.observableArrayList("свободное размещение");
    private ObservableList<String> list3 = FXCollections.observableArrayList("Передняя", "Задняя", "Слева", "Справа", "Нижняя", "Верхняя");

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML

    private void handleOpen() throws IOException {
        //String fileName = "/Users/prologistic/source.txt";
        // readUsingFiles(fileName);
        String[] open1 = new String[10000];
        String[][] openrazb = new String[10000][15];
        int rrr = 0;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FileReader fr = new FileReader(file);

            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                open1[rrr] = line;
                // считываем остальные строки в цикле
                line = reader.readLine();

                rrr++;
            }
            fr.close();
        }


        for (int i = 0; i < rrr; i++) openrazb[i] = (open1[i]).split(";");

        WrazmerKorpusa = Integer.parseInt(openrazb[1][0]);
        HrazmerKorpusa = Integer.parseInt(openrazb[1][1]);
        LrazmerKorpusa = Integer.parseInt(openrazb[1][0]);
        ThicknessRrazmerKorpusa = Integer.parseInt(openrazb[1][1]);

        n = rrr - 3;
        bd = new Bd[n];
        osnovnoi=new Ploskosti[n];
        for (int i = 3; i < rrr; i++) {
            int mmm[] = new int[7];
            if (openrazb[i][4].trim().length() == 0) mmm[0] = -1000;
            else mmm[0] = Integer.parseInt(openrazb[i][4]);
            if (openrazb[i][5].trim().length() == 0) mmm[1] = -1000;
            else mmm[1] = Integer.parseInt(openrazb[i][5]);
            if (openrazb[i][6].trim().length() == 0) mmm[2] = -1000;
            else mmm[2] = Integer.parseInt(openrazb[i][6]);
            if (openrazb[i][7].trim().length() == 0) mmm[3] = -1000;
            else mmm[3] = Integer.parseInt(openrazb[i][7]);
            if (openrazb[i][8].trim().length() == 0) mmm[4] = 0;
            else mmm[4] = Integer.parseInt(openrazb[i][8]);
            if (openrazb[i][9].trim().length() == 0) mmm[5] = 0;
            else mmm[5] = Integer.parseInt(openrazb[i][9]);
            if (openrazb[i][10].trim().length() == 0) mmm[6] = 0;
            else mmm[6] = Integer.parseInt(openrazb[i][10]);

            try {
                bd[i - 3] = new Bd("№" + (i - 2) + " " + openrazb[i][0], Integer.parseInt(openrazb[i][1]),
                        Integer.parseInt(openrazb[i][2]), Integer.parseInt(openrazb[i][3]), mmm[0],
                        mmm[1], mmm[2], mmm[3], mmm[4], mmm[5],mmm[6]);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Неверный формат строк!");
                alert.showAndWait();
            }
        }

        combobox4.setItems(list3);
        combobox4.getSelectionModel().select(ploskostpostr);


        System.out.println(n);


        combobox4.getSelectionModel().selectedIndexProperty().
                addListener((ObservableValue<? extends Number> ov4, Number old_val4, Number new_val4) -> {
                    ploskostpostr = new_val4.intValue();
                });


        for (int i = 0; i < bd.length; i++)
            System.out.println(bd[i].names() + " " + bd[i].width() + " " + bd[i].haight() + " " + bd[i].length() + " " + bd[i].coordX() + " " +
                    bd[i].coordY() + " " + bd[i].coordZ() + " " + bd[i].ryadom() + " " + bd[i].angleX() + " " + bd[i].angleY());


        System.out.println("ok");

    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("AddressApp");
        // alert.setHeaderText("About");
        // alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
        alert.showAndWait();
    }

    @FXML
    private void handleSave() {
    }


    @FXML
    private void handleLocaterazmesh() throws IOException {
        //  metodrazmesh(); metodproverka();
        //  metodrazmeshryadom();
        //  metodrazmeshostaln();
        metodrazmeshangletochki();
        metodrazmeshanglepixels();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Расчеты завершились.");
        alert.showAndWait();

        System.out.println("t1 X="+osnovnoi[0].poluchtochka1(0)+" Y"+osnovnoi[0].poluchtochka1(1)+" Z"+osnovnoi[0].poluchtochka1(2));
        System.out.println("t2 X="+osnovnoi[0].poluchtochka2(0)+" Y"+osnovnoi[0].poluchtochka2(1)+" Z"+osnovnoi[0].poluchtochka2(2));
        System.out.println("t3 X="+osnovnoi[0].poluchtochka3(0)+" Y"+osnovnoi[0].poluchtochka3(1)+" Z"+osnovnoi[0].poluchtochka3(2));
        System.out.println("t4 X="+osnovnoi[0].poluchtochka4(0)+" Y"+osnovnoi[0].poluchtochka4(1)+" Z"+osnovnoi[0].poluchtochka4(2));
        System.out.println("t5 X="+osnovnoi[0].poluchtochka5(0)+" Y"+osnovnoi[0].poluchtochka5(1)+" Z"+osnovnoi[0].poluchtochka5(2));
        System.out.println("t 6X="+osnovnoi[0].poluchtochka6(0)+" Y"+osnovnoi[0].poluchtochka6(1)+" Z"+osnovnoi[0].poluchtochka6(2));
        System.out.println("t7 X="+osnovnoi[0].poluchtochka7(0)+" Y"+osnovnoi[0].poluchtochka7(1)+" Z"+osnovnoi[0].poluchtochka7(2));
        System.out.println("t8 X="+osnovnoi[0].poluchtochka8(0)+" Y"+osnovnoi[0].poluchtochka8(1)+" Z"+osnovnoi[0].poluchtochka8(2));

        osnovnoi[0].dobavlpixels((short)11,(short)1,(short)1);
        for(int i=0;i<osnovnoi[0].lengthpix();i++) System.out.print(osnovnoi[0].pixels(0,i)+" "+osnovnoi[0].pixels(1,i)+";");

        System.out.println("ok");
    }



    public void metodrazmeshangletochki() {
        for(int i=0;i<bd.length;i++) {
            if (bd[i].angleX() != 0 || bd[i].angleY() != 0|| bd[i].angleZ() != 0) {
                double t1[] = new double[3], t2[] = new double[3], t3[] = new double[3], t4[] = new double[3],
                        t5[] = new double[3], t6[] = new double[3], t7[] = new double[3], t8[] = new double[3];
                kolvosnaclonom++;
                osnovnoi[i] = new Ploskosti(bd[i].names(), bd[i].width(), bd[i].haight(), bd[i].length(), bd[i].coordX(), bd[i].coordY(), bd[i].coordZ(),
                        bd[i].angleX(), bd[i].angleY(),bd[i].angleZ());
                if (bd[i].angleX() != 0) {


                    double ddd = Math.sqrt(Math.pow(osnovnoi[i].width(), 2) + Math.pow(osnovnoi[i].haight(), 2));
                    double ugol = Math.toDegrees(Math.asin(osnovnoi[i].width() / ddd)) - osnovnoi[i].angleX();
                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    t2[0] = t1[0] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t2[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t2[2] = t1[2];
                    t3[0] = t1[0] + osnovnoi[i].width() * Math.cos(Math.toRadians(osnovnoi[i].angleX()));
                    t3[1] = t1[1] + osnovnoi[i].width() * Math.sin(Math.toRadians(osnovnoi[i].angleX()));
                    t3[2] = t1[2];
                    if (ugol > 0) {
                        t4[0] = t1[0]+ osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t4[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t4[2] = t1[2];
                    } else {
                        t4[0] = t1[0]- osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                        t4[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                        t4[2] = t1[2];
                    }
                    t4[0] = t3[0] - osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t4[1] = t3[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleX()));
                    t4[2] = t1[2];
                    t5[0] = t1[0] ;
                    t5[1] = t1[1];
                    t5[2] = t1[2] + osnovnoi[i].lenght();
                    t6[0] = t2[0];
                    t6[1] = t2[1];
                    t6[2] = t2[2] + osnovnoi[i].lenght();
                    t7[0] = t3[0];
                    t7[1] = t3[1];
                    t7[2] = t3[2] + osnovnoi[i].lenght();
                    t8[0] = t4[0];
                    t8[1] = t4[1];
                    t8[2] = t4[2] + osnovnoi[i].lenght();
                } else if(osnovnoi[i].angleY()!=0){
                   double ddd = Math.sqrt(Math.pow(osnovnoi[i].lenght(), 2) + Math.pow(osnovnoi[i].haight(), 2));
                   double ugol = Math.toDegrees(Math.asin(osnovnoi[i].lenght() / ddd)) - osnovnoi[i].angleY();

                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    t2[0] = t1[0];
                    t2[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                    t2[2] = t1[2]- osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                    t3[0] = t1[0]+osnovnoi[i].width();
                    t3[1] = t1[1];
                    t3[2] = t1[2];
                    t4[0] = t3[0];
                    t4[1] = t2[1];
                    t4[2] = t2[2];
                    t5[0] = t1[0];
                    t5[1] = t1[1] + osnovnoi[i].lenght() * Math.sin(Math.toRadians(osnovnoi[i].angleY()));
                    t5[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleY()));
                    if (ugol > 0) {
                        t6[0] = t1[0];
                        t6[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t6[2] = t1[2]+ osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                    } else {
                        t6[0] = t1[0];
                        t6[1] = t1[1] + osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleY()));
                        t6[2] = t1[2]- osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleY()));
                    }
                    t7[0] = t3[0];
                    t7[1] = t3[1] + osnovnoi[i].lenght() * Math.sin(Math.toRadians(osnovnoi[i].angleY()));
                    t7[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleY()));
                    t8[0] = t3[0];
                    t8[1] = t6[1];
                    t8[2] = t6[2];

                }else if(osnovnoi[i].angleZ()!=0) {
                    t1[0] = osnovnoi[i].coordX();
                    t1[1] = osnovnoi[i].coordY();
                    t1[2] = osnovnoi[i].coordZ();
                    double ddd = Math.sqrt(Math.pow(osnovnoi[i].lenght(), 2) + Math.pow(osnovnoi[i].width(), 2));
                    double ugol = Math.toDegrees(Math.asin(osnovnoi[i].width() / ddd)) - osnovnoi[i].angleZ();
                    t2[0] = t1[0];
                    t2[1] = t1[1] + osnovnoi[i].haight();
                    t2[2] = t1[2];
                    t3[0] = t1[0] + osnovnoi[i].width() * Math.cos(Math.toRadians(osnovnoi[i].angleZ()));
                    t3[1] = t1[1];
                    t3[2] = t1[2]+ osnovnoi[i].width() * Math.cos(Math.toRadians(osnovnoi[i].angleZ()));
                    t4[0] = t3[0];
                    t4[1] = t2[1];
                    t4[2] = t3[2];
                    t5[0] = t1[0]- osnovnoi[i].lenght() * Math.cos(Math.toRadians(90-osnovnoi[i].angleZ()));;
                    t5[1] = t1[1];
                    t5[2] = t1[2] + osnovnoi[i].lenght() * Math.cos(Math.toRadians(osnovnoi[i].angleZ()));
                    t6[0] = t5[0];
                    t6[1] = t2[1];
                    t6[2] = t5[2];

                    if (ugol > 0) {
                        t7[0] = t1[0]+ osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleZ()));
                        t7[1] = t1[1];
                        t7[2] = t1[2]+ osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleZ()));
                    } else {
                        t7[0] = t1[0]- osnovnoi[i].haight() * Math.cos(Math.toRadians(90 - osnovnoi[i].angleZ()));
                        t7[1] = t1[1];
                        t7[2] = t1[2]+ osnovnoi[i].haight() * Math.sin(Math.toRadians(90 - osnovnoi[i].angleZ()));
                    }
                    t8[0] = t7[0];
                    t8[1] = t2[1];
                    t8[2] = t7[2];

                }
                osnovnoi[i].osntochkidobavl(t1,t2,t3,t4,t5,t6,t7,t8);
            }
        }

    }
    private void metodrazmeshanglepixels() {
        for(int i=0;i<kolvosnaclonom;i++) {
            if (osnovnoi[i].angleX()!=0) {
///первая плоскость
                if (Math.pow((osnovnoi[i].poluchtochka3(0)-osnovnoi[i].poluchtochka1(0)),2)>=
                        Math.pow((osnovnoi[i].poluchtochka2(0)-osnovnoi[i].poluchtochka1(0)),2)){

                    int ttn1[]=new int [3]; int ttk3[]=new int[3];int ttn2[]=new int [3]; int ttk4[]=new int[3];
                    ttn1[0]=(int)Math.round(osnovnoi[i].poluchtochka1(0));
                    ttn1[1]=(int)Math.round(osnovnoi[i].poluchtochka1(1));
                    ttn1[2]=(int)Math.round(osnovnoi[i].poluchtochka1(2));
                    ttk3[0]=(int)Math.round(osnovnoi[i].poluchtochka3(0));
                    ttk3[1]=(int)Math.round(osnovnoi[i].poluchtochka3(1));
                    ttk3[2]=(int)Math.round(osnovnoi[i].poluchtochka3(2));

                    ttn2[0]=(int)Math.round(osnovnoi[i].poluchtochka2(0));
                    ttn2[1]=(int)Math.round(osnovnoi[i].poluchtochka2(1));
                    ttn2[2]=(int)Math.round(osnovnoi[i].poluchtochka2(2));
                    ttk4[0]=(int)Math.round(osnovnoi[i].poluchtochka4(0));
                    ttk4[1]=(int)Math.round(osnovnoi[i].poluchtochka4(1));
                    ttk4[2]=(int)Math.round(osnovnoi[i].poluchtochka4(2));
                    System.out.println("!");


//по х
                    for(int j=ttn1[0];j<ttk3[0];j++){

                        int tt1[]=new int[3]; int tt2[]=new int[3];
                        tt1[0]=j; tt1[2]=ttn1[2];
                        tt1[1]=(tt1[0]-ttn1[0])/(ttk3[0]-ttn1[0])*(ttk3[1]-ttn1[1])+ttn1[1];

                        tt2[0]=(int)Math.round(osnovnoi[i].poluchtochka2(0))-(int)Math.round(osnovnoi[i].poluchtochka1(0))+tt1[0];
                        tt2[2]=ttn1[2];
                        tt2[1]=(tt2[0]-ttn2[0])/(ttk4[0]-ttn2[0])*(ttk4[1]-ttn2[1])+ttn2[1];
                        //по у
                        for(int k=tt1[1];k<tt2[1];k++) {
                            short x,y,z=(short)tt1[2];
                            y=(short)k;
                            x=(short)((k-tt1[1])/(tt2[1]-tt1[1])*(tt2[0]-tt1[0])+tt1[0]);

                            osnovnoi[i].dobavlpixels(x,y,z);
                        }

                    }


                }

            }
        }


    }




}
