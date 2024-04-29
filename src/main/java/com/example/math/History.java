package com.example.math;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.math.CalculateApp.HISTORY;

public class History{
    static Stage stage = new Stage();
    static String HISToRY = String.join(",", HISTORY);
    static void showHistory(){
        Text Hist = new Text(HISTORY.toString());
        Hist.setFont(Font.font("Arial", 24));
        FlowPane pane = new FlowPane(Orientation.VERTICAL,Hist);
        Scene scene = new Scene(pane, 400,250);
        stage.setScene(scene);
        stage.setTitle("History");
        stage.show();
    }
}
