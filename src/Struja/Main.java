package Struja;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    static Integer tekuci;
    static Integer prethodni;
    static Integer potrosnja;
    static Integer ukupnokwh;
    static Double procenat;
    static String mesec;

    static Double ukupno1;
    static Double ukupno2;
    static Double ukupno3;
    static Double ukupno4;
    static Double ukupno5;
    static Double ukupno6;
    static Double ukupno7;
    static Double ukupno8;
    static Double ukupno9;
    static Double ukupno10;
    static Double ukupno11;
    static Double ukupno12;
    static Double ukupno13;
    static Double ukupno14;

    static Double cenaPoJedinici;
    static Double ukupnoPriz;
    static Double trosak;
    static Double taksa;
    static Double ukupnoPrizPotk;
    static Double ukupnoPotk;

    static Double zzvtCena;
    static Double zzvtPotrosnja;
    static Double zzntCena;
    static Double zzntPotrosnja;
    static Double pzvtCena;
    static Double pzvtPotrosnja;
    static Double pzntCena;
    static Double pzntPotrosnja;


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);

        root.setPadding(new Insets(10,10,10,10));


        VBox top = new VBox(10);
        top.setAlignment(Pos.CENTER);

        Label lbPrvaLinija = new Label("Racun za struju");


        HBox hbMesec = new HBox(10);
        Label lbMesec = new Label("Unesi mesec");
        TextField tfMesec = new TextField();
        tfMesec.setMaxWidth(100);
        hbMesec.getChildren().addAll(lbMesec, tfMesec);

        HBox hbGodina = new HBox(10);
        Label lbGodina = new Label("Unesi godinu");
        TextField tfGodina = new TextField();
        tfGodina.setMaxWidth(100);
        hbGodina.getChildren().addAll(lbGodina, tfGodina);


        Button btUnesiMesecIGodinu = new Button("Unesi mesec i godinu");

        btUnesiMesecIGodinu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(tfMesec.getText().equals("") || tfGodina.getText().equals("")){
                    AllertBox.prikazi("Greska", "Molimo Vas da unesete mesec i godinu");
                }else {
                    mesec = tfMesec.getText();
                    String s = "Racun za struju za " + mesec + " " + tfGodina.getText();
                    lbPrvaLinija.setText(s);
                    lbPrvaLinija.setTextFill(Color.ORANGE);
                    lbPrvaLinija.setFont(Font.font(25));
                }
            }
        });

        top.getChildren().addAll(lbPrvaLinija,hbMesec,hbGodina);

        //gornji - Vbox za unos potrosnje

        VBox gornji = new VBox(10);


        HBox prvi = new HBox(10);
        Label lbUkupnokwh = new Label("Unesi ukupnu potrosnju u kWh");
        TextField tfUkupnokwh = new TextField();
        tfUkupnokwh.setMaxWidth(100);

        prvi.getChildren().addAll(lbUkupnokwh, tfUkupnokwh);


        HBox drugi = new HBox(10);
        Label lbPrethodni = new Label("Unesi stanje brojila za prethodni mesec");
        TextField tfPrethodni = new TextField();
        tfPrethodni.setMaxWidth(100);

        drugi.getChildren().addAll(lbPrethodni, tfPrethodni);


        HBox treci = new HBox(10);
        Label lbTekuci = new Label("Unesi stanje brojila za tekuci mesec");
        TextField tfTekuci = new TextField();
        tfPrethodni.setMaxWidth(100);

        treci.getChildren().addAll(lbTekuci, tfTekuci);


        HBox cetvrti = new HBox(10);
        Label lb4Potrosnja = new Label("Potrosnja za tekuci mesec  u kWh");
        Label lbPotrosnja = new Label("");
        lbPotrosnja.setTextFill(Color.BLUEVIOLET);

        cetvrti.getChildren().addAll(lb4Potrosnja, lbPotrosnja);


        HBox peti = new HBox(10);
        Label lb5Procenat = new Label("Procenat ukupne potrosnje za tekuci mesec");
        Label lbProcenat = new Label("");
        lbProcenat.setTextFill(Color.BLUEVIOLET);

        peti.getChildren().addAll(lb5Procenat, lbProcenat);



        Button btUnesiPodatke = new Button("Unesi podatke o potrosnji");
        btUnesiPodatke.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(tfUkupnokwh.getText().equals("")){
                    AllertBox.prikazi("Greska", "Molimo Vas da unesete mesec i godinu");
                }
                else {
                    ukupnokwh = Integer.parseInt(tfUkupnokwh.getText());
                    if(tfTekuci.getText().equals("") || tfPrethodni.getText().equals("") ){
                        AllertBox.prikazi("Greska", "Molimo Vas da unesete mesec i godinu");
                    }else{
                        tekuci = Integer.parseInt(tfTekuci.getText());
                        prethodni = Integer.parseInt(tfPrethodni.getText());
                        potrosnja = tekuci - prethodni;
                        procenat = (potrosnja*100.0)/ukupnokwh;
                        lbPotrosnja.setText(potrosnja.toString());
                        lbProcenat.setText(procenat.toString()+"%");
                    }
                }
            }
        });

        gornji.getChildren().addAll(prvi,drugi, treci,btUnesiPodatke, cetvrti, peti);

        //srednji - VBoz za unos podataka sa racuna

        VBox srednji = new VBox(10);

        VBox vb1 = new VBox(10);
        Label lb1= new Label("1) Obracunska snaga");
        HBox hb1 = new HBox(10);
        Label lb1Cena = new Label("Unesi cenu po jedinici");
        TextField tfCena = new TextField();
        tfCena.setMaxWidth(100);
        hb1.getChildren().addAll(lb1Cena, tfCena);
        VBox vbsrednji2 = new VBox(10);
        Label lb1Ukupno = new Label("Ukupna obracunska snaga");
        Label lbUkupno1 = new Label("");
        lbUkupno1.setTextFill(Color.BLUEVIOLET);
        vbsrednji2.getChildren().addAll(lb1Ukupno, lbUkupno1);
        vb1.getChildren().addAll(lb1, hb1, vbsrednji2);


        VBox vb2 = new VBox(10);
        Label lb2 = new Label("2) Trosak garantovanog snabdevaca");
        TextField tfTrosak = new TextField();
        tfTrosak.setMaxWidth(100);
        vb1.getChildren().addAll(lb2, tfTrosak);


        VBox vb3 = new VBox(10);
        Label lb3 = new Label("3) Energija");
        HBox hbEnergija = new HBox(20);

        VBox vbZZ = new VBox(10);
        Label lbZZ = new Label("Zelena zona");
        Label lbZZVTPotrosnja = new Label("Unesi ukupnu potrosnju u kwh u zelenoj zoni po visoj tarifi");
        TextField tfZZVTPotrosnja = new TextField();
        tfZZVTPotrosnja.setMaxWidth(100);
        Label lbZZVTCena = new Label("Unesi cenu za zelenu zonu po visoj tarifi");
        TextField tfZZVTCena = new TextField();
        tfZZVTCena.setMaxWidth(100);

        Label lbZZNTPotrosnja = new Label("Unesi ukupnu potrosnju u kwh u zelenoj zoni po nizoj tarifi");
        TextField tfZZNTPotrosnja = new TextField();
        tfZZNTPotrosnja.setMaxWidth(100);
        Label lbZZNTCena = new Label("Unesi cenu za zelenu zonu po nizoj tarifi");
        TextField tfZZNTCena = new TextField();
        tfZZNTCena.setMaxWidth(100);

        vbZZ.getChildren().addAll(lbZZ,lbZZVTPotrosnja, tfZZVTPotrosnja, lbZZVTCena, tfZZVTCena,
                lbZZNTPotrosnja,tfZZNTPotrosnja,lbZZNTCena,tfZZNTCena
        );
        lbZZ.setTextFill(Color.GREEN);
        lbZZNTCena.setTextFill(Color.GREEN);
        lbZZNTPotrosnja.setTextFill(Color.GREEN);
        lbZZVTCena.setTextFill(Color.GREEN);
        lbZZVTPotrosnja.setTextFill(Color.GREEN);

        VBox vbPZ = new VBox(10);
        Label lbPZ = new Label("Plava zona");
        Label lbPZVTPotrosnja = new Label("Unesi ukupnu potrosnju u kwh u plavoj zoni po visoj tarifi");
        TextField tfPZVTPotrosnja = new TextField();
        tfPZVTPotrosnja.setMaxWidth(100);
        Label lbPZVTCena = new Label("Unesi cenu za plavu zonu po visoj tarifi");
        TextField tfPZVTCena = new TextField();
        tfPZVTCena.setMaxWidth(100);

        Label lbPZNTPotrosnja = new Label("Unesi ukupnu potrosnju u kwh u plavoj zoni po nizoj tarifi");
        TextField tfPZNTPotrosnja = new TextField();
        tfPZNTPotrosnja.setMaxWidth(100);
        Label lbPZNTCena = new Label("Unesi cenu za plavu zonu po nizoj tarifi");
        TextField tfPZNTCena = new TextField();
        tfPZNTCena.setMaxWidth(100);

        lbPZ.setTextFill(Color.BLUE);
        lbPZNTCena.setTextFill(Color.BLUE);
        lbPZNTPotrosnja.setTextFill(Color.BLUE);
        lbPZVTCena.setTextFill(Color.BLUE);
        lbPZVTPotrosnja.setTextFill(Color.BLUE);

        vbPZ.getChildren().addAll(lbPZ,lbPZVTPotrosnja, tfPZVTPotrosnja, lbPZVTCena,
                tfPZVTCena,lbPZNTPotrosnja, tfPZNTPotrosnja, lbPZNTCena, tfPZNTCena
        );

        hbEnergija.getChildren().addAll(vbZZ, vbPZ);
        vb3.getChildren().addAll(lb3,hbEnergija);


        VBox vb4 = new VBox(10);
        Label lb4 = new Label("4) Zaduzenje u obracunskom periodu (1+2+3)");
        Label lblZaduzenje123 = new Label("");
        lblZaduzenje123.setTextFill(Color.BLUEVIOLET);
        vb4.getChildren().addAll(lb4, lblZaduzenje123);


        VBox vb5 = new VBox(10);
        Label lb5 = new Label("5) Popust od 5% za placanje prethodnog racuna u periodu dospeca");
        Label lbPopust = new Label("");
        lbPopust.setTextFill(Color.BLUEVIOLET);
        vb5.getChildren().addAll(lb5, lbPopust);


        VBox vb6 = new VBox(10);
        Label lb6 = new Label("6) Naknada za podsticaj povlascenih proizvodjaca el. energije");
        Label lb6CenaPoJedinici = new Label("Unesite cenu po jedinici");
        TextField tf6CenaPoJedinici = new TextField();
        tf6CenaPoJedinici.setMaxWidth(100);
        Label lb6Ukupno = new Label("Iznos naknade");
        Label lbUkupno6 = new Label("");
        lbUkupno6.setTextFill(Color.BLUEVIOLET);
        vb6.getChildren().addAll(lb6, lb6CenaPoJedinici, tf6CenaPoJedinici, lb6Ukupno,lbUkupno6);


        VBox vb7 = new VBox(10);
        Label lb7 = new Label("7) Naknada za unapredjenje energetske efikasnosti");
        Label lb7CenaPoJedinici = new Label("Unesite cenu po jedinici");
        TextField tf7CenaPoJedinici = new TextField();
        tf7CenaPoJedinici.setMaxWidth(100);
        Label lb7Ukupno = new Label("Iznos naknade");
        Label lbUkupno7 = new Label("");
        lbUkupno7.setTextFill(Color.BLUEVIOLET);
        vb7.getChildren().addAll(lb7, lb7CenaPoJedinici, tf7CenaPoJedinici,lb7Ukupno,lbUkupno7);


        VBox vb8 = new VBox(10);
        Label lb8 = new Label("8) Osnovica za obracun akcize (4+5+6+7)");
        Label lb8Osnovica = new Label("");
        lb8Osnovica.setTextFill(Color.BLUEVIOLET);
        vb8.getChildren().addAll(lb8, lb8Osnovica);


        VBox vb9 = new VBox(10);
        Label lb9 = new Label("9) Iznos akcize (7.5%)");
        Label lb9Akciza = new Label("");
        lb9Akciza.setTextFill(Color.BLUEVIOLET);
        vb9.getChildren().addAll(lb9, lb9Akciza);


        VBox vb10 = new VBox(10);
        Label lb10 = new Label("10) Osnovica za PDV (4+5+6+7+9)");
        Label lb10Osnovica = new Label("");
        lb10Osnovica.setTextFill(Color.BLUEVIOLET);
        vb10.getChildren().addAll(lb10, lb10Osnovica);


        VBox vb11 = new VBox(10);
        Label lb11 = new Label("11) Iznos PDV-a (20%)");
        Label lb11PDV = new Label("");
        lb11PDV.setTextFill(Color.BLUEVIOLET);
        vb11.getChildren().addAll(lb11, lb11PDV);


        VBox vb12 = new VBox(10);
        Label lb12 = new Label("12) Umanjenje za en. ugrozene kupce");
        Label lb12umanjenje = new Label("");
        lb12umanjenje.setTextFill(Color.BLUEVIOLET);
        vb12.getChildren().addAll(lb12, lb12umanjenje);


        VBox vb13 = new VBox(10);
        Label lb13 = new Label("13) Zaduzenje za obracunski period (10+11+12)");
        Label lb13zaduzenje = new Label("");
        lb13zaduzenje.setTextFill(Color.BLUEVIOLET);
        vb13.getChildren().addAll(lb13, lb13zaduzenje);


        VBox vb14 = new VBox(10);
        Label lb14 = new Label("14) Taksa za javni medijski servis");
        TextField tf14taksa = new TextField();
        tf14taksa.setMaxWidth(100);
        vb14.getChildren().addAll(lb14, tf14taksa);


        //donji - VBoz za iznos u din
        VBox donji = new VBox(10);

        HBox hbDonji1 = new HBox(10);
        Label lbUkupno = new Label("Ukupno zaduzenje za obracunski period za prizemlje je");
        Label lbZaduzenje = new Label("");
        lbZaduzenje.setTextFill(Color.DEEPPINK);
        hbDonji1.getChildren().addAll(lbUkupno, lbZaduzenje);


        HBox hbDonji2 = new HBox(10);
        Label lbukupno = new Label("Unesi ukupno zaduzenje za obracunski period");
        TextField tfukupno = new TextField();
        hbDonji2.getChildren().addAll(lbukupno, tfukupno);


        HBox hbDonji3 = new HBox(10);
        Label lbUkupnoPotk = new Label("Ukupno zaduzenje za obracunski period za potkrovlje je");
        Label lbZaduzenjePotk = new Label("");
        lbZaduzenjePotk.setTextFill(Color.DEEPPINK);
        hbDonji3.getChildren().addAll(lbUkupnoPotk, lbZaduzenjePotk);


        Button btKraj = new Button("Izracunaj za potkrovlje");
        btKraj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(tfukupno.getText().equals("")){
                    AllertBox.prikazi("Greska", "Molimo Vas da unesete mesec i godinu");
                }else{
                    ukupnoPrizPotk = Double.parseDouble(tfukupno.getText());
                    ukupnoPotk = ukupnoPrizPotk - ukupnoPriz;
                    lbZaduzenjePotk.setText(ukupnoPotk.toString() + " din");
                    lbZaduzenjePotk.setFont(Font.font(15));
                }
            }
        });


        donji.getChildren().addAll(hbDonji1,hbDonji2,hbDonji3, btKraj);

        Button btIzracunaj = new Button("Izracunaj");
        btIzracunaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*
                if(tfCena.getText().equals(""))
                    lbGreska.setText("Molimo Vas da unesete cenu");
                else{
                    lbGreska.setText("");
                    cenaPoJedinici = Double.parseDouble(tfCena.getText());
                    ukupno1 = potrosnja*cenaPoJedinici;
                    lbUkupno1.setText(ukupno1.toString());

                    if(tfTrosak.getText().equals(""))
                        lbGreska.setText("Molimo Vas da unesete trosak");
                    else{
                        lbGreska.setText("");
                        trosak = Double.parseDouble(tfTrosak.getText());
                        ukupno2 = trosak/2;
                    }

                }


                */

                try {
                    cenaPoJedinici = Double.parseDouble(tfCena.getText());
                    ukupno1 = potrosnja * cenaPoJedinici;
                    lbUkupno1.setText(ukupno1.toString());
                    
                    trosak = Double.parseDouble(tfTrosak.getText());
                    ukupno2 = trosak / 2;

                    zzvtPotrosnja = Double.parseDouble(tfZZVTPotrosnja.getText());
                    zzvtCena = Double.parseDouble(tfZZVTCena.getText());
                    zzntPotrosnja = Double.parseDouble(tfZZNTPotrosnja.getText());
                    zzntCena = Double.parseDouble(tfZZNTCena.getText());
                    pzvtPotrosnja = Double.parseDouble(tfZZVTPotrosnja.getText());
                    pzvtCena = Double.parseDouble(tfZZVTCena.getText());
                    pzntPotrosnja = Double.parseDouble(tfZZNTPotrosnja.getText());
                    pzntCena = Double.parseDouble(tfZZNTCena.getText());

                    ukupno3 = izracunajPotrosnju(zzvtPotrosnja, zzvtCena) +
                            izracunajPotrosnju(zzntPotrosnja, zzntCena) +
                            izracunajPotrosnju(pzvtPotrosnja, pzvtCena) +
                            izracunajPotrosnju(pzntPotrosnja, pzntCena);


                    ukupno4 = ukupno1 + ukupno2 + ukupno3;
                    lblZaduzenje123.setText(ukupno4.toString());


                    ukupno5 = -ukupno4 * 0.05;
                    lbPopust.setText(ukupno5.toString());

                    cenaPoJedinici = Double.parseDouble(tf6CenaPoJedinici.getText());
                    ukupno6 = cenaPoJedinici * potrosnja;
                    lbUkupno6.setText(ukupno6.toString());

                    cenaPoJedinici = Double.parseDouble(tf7CenaPoJedinici.getText());
                    ukupno7 = cenaPoJedinici * potrosnja;
                    lbUkupno7.setText(ukupno7.toString());

                    ukupno8 = ukupno4 + ukupno5 + ukupno6 + ukupno7;
                    lb8Osnovica.setText(ukupno8.toString());

                    ukupno9 = ukupno8 * 0.075;
                    lb9Akciza.setText(ukupno9.toString());

                    ukupno10 = ukupno4 + ukupno5 + ukupno6 + ukupno7 + ukupno9;
                    lb10Osnovica.setText(ukupno10.toString());

                    ukupno11 = ukupno10 * 0.2;
                    lb11PDV.setText(ukupno11.toString());

                    ukupno12 = 0.0;
                    lb12umanjenje.setText(ukupno12.toString());

                    ukupno13 = ukupno10 + ukupno11 + ukupno12;
                    lb13zaduzenje.setText(ukupno13.toString());

                    taksa = Double.parseDouble(tf14taksa.getText());
                    ukupno14 = taksa / 2;


                    ukupnoPriz = ukupno13 + ukupno14;
                    lbZaduzenje.setText(ukupnoPriz.toString() + " din");
                    lbZaduzenje.setFont(Font.font(15));

                }catch (NumberFormatException e){
                    AllertBox.prikazi("Greska", "Molimo Vas da unesete mesec i godinu");
                }

            }
        });



        srednji.getChildren().addAll(vb1, vb2, vb3,vb4,vb5,vb6,vb7,vb8,vb9,
                vb10,vb11,vb12,vb13,vb14,btIzracunaj);


        ScrollPane sp = new ScrollPane();

        root.getChildren().addAll(top, btUnesiMesecIGodinu, gornji, srednji, donji);
        sp.setContent(root);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Scene scene = new Scene(sp, 600,600);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Kalkulator potrosnje elektricne energije");

        primaryStage.show();

    }

    public Double izracunajPotrosnju(Double ukupnaPotrosnja, Double cena){
        return ukupnaPotrosnja*procenat*cena/100;
    }
}


