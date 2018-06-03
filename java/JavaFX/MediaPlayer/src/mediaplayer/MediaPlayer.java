/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author olivermensah
 */
public class MediaPlayer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Player player = new Player("file:///media/olivermensah/3C6BE0FF427960C4/Downloads/(9)%20Adding%20to%20a%20Priority%20Queue%20Heap%20-%20YouTube.mp4");
        Scene scene = new Scene(player, 720, 480, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
