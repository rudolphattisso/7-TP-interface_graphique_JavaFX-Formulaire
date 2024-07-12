package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setMaxHeight(144);
        stage.setMaxWidth(400);

        //INSTANCIATION
        Label label = new Label("User Input :  ");
        Label label2 = new Label("Copy of the User Input : ");
        //création des champs dont un avecc saisie utilisateur
        TextField textField1 = new TextField("Enter Text");
        TextField textField2 = new TextField("Enter Text");
        //empeche la modification du champ 
        textField2.setEditable(false);
       
        Button buttonCopy = new Button("Copy");
        Button buttonErase = new Button("Erase");
        Button buttonQuit = new Button("Quit");
       
        //instanciation de la Vbox qui contiendra les boutons et configuration de la position des élements au sein de la Vbox
        VBox vbox1 = new VBox(buttonCopy,buttonErase,buttonQuit);
        vbox1.setSpacing(10); //spacing in bbox
        vbox1.setAlignment(Pos.CENTER);

        //instanciation de la gridpane afin de position les differents éléments dans la scène;
        GridPane gridPane = new GridPane(); 
        gridPane.add(label, 0,0);
        gridPane.add(label2, 0,1);
        gridPane.add(textField1,1,0);
        gridPane.add(textField2,1,1);
        gridPane.add(vbox1,2,0,1,2);

    
       
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);

        gridPane.getRowConstraints().addAll(row1,row2);

       //positionnement de la grdpane dans la scène
       gridPane.setAlignment(Pos.CENTER); //.SETALIGNMENT
       gridPane.setHgap(20);
       gridPane.setVgap(10);

        //"ASSEMBLAGE"
        Scene scene = new Scene(gridPane, 640, 480);
       
        //evenement qui copie le text dans le champ 1 et qui le colle dans champ 2;
        buttonCopy.setOnAction(e -> {
        textField2.setText(textField1.getText());
        });
       

 
        // bouton qui efface le champ 2
        buttonErase.setOnAction(e ->{
        textField2.clear();
        });

        //bouton qui termine programme
        buttonQuit.setOnAction(e ->Platform.exit());  //.EXIT
        stage.setScene(scene);
        stage.show();

    }  

}