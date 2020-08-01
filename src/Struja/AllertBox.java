package Struja;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AllertBox {

    //metod je static jer ne zelimo da pravimo poseban primerak klase
    public static void prikazi(String naslov, String poruka) {
        Stage prozor = new Stage();

        prozor.initModality(Modality.APPLICATION_MODAL); // da ne moze da se radi nista van ovog prozora, mora on prvo da se zatvori
        prozor.setTitle(naslov);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label labela = new Label(poruka);
        labela.setTextFill(Color.RED);
        Button zatvori = new Button("Zatvori prozor");
        zatvori.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                prozor.close();
            }
        });

        root.getChildren().addAll(labela, zatvori);

        Scene scena = new Scene(root,500,120);
        prozor.setScene(scena);
        prozor.showAndWait(); // opet da bi ovaj prozor morao da se zatvori
    }



}
