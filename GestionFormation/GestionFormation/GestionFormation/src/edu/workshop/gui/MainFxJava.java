package edu.workshop.gui;



import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
/**
 *
 * @author Dali
 */
public class MainFxJava extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
   Parent root;
    

        
        Button btn = new Button();
        final int initialValue = 100;

        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
       try{
        
          root=FXMLLoader.load(getClass().getResource("AjouterFormation.FXML"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Gestion Formation");
        primaryStage.setScene(scene);
        primaryStage.show();}
       catch(IOException ex){
       System.out.print(ex.getMessage());
       }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
