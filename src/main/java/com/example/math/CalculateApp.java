package com.example.math;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;


public class CalculateApp  extends Application {
    static ArrayList<String> HISTORY = new ArrayList<>();
    static Button sum = new Button("Sum");
    static Button division = new Button("Division");
    static Button multiplication = new Button("Multiplication");
    static Button subtraction = new Button("Subtraction");
    static Stage primaryStage = new Stage();
    static Button history = new Button("History");
    @Override
    public void start(Stage primaryStage) throws Exception {
        CalculateApp.setMain();

    }
    static void setMain(){
        AnchorPane root = new AnchorPane(sum, division, multiplication, subtraction, history);
        Scene scene = new Scene(root, 400, 250);
        sum.setOnAction(new EventHandler<ActionEvent>(){@Override public void handle(ActionEvent actionEvent) {Summa.setSum(); primaryStage.close();}});
        division.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Division.setDiv(); primaryStage.close();}});
        multiplication.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Mult.setMult(); primaryStage.close();}});
        subtraction.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Sub.setSub();primaryStage.close();}});
        history.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {History.showHistory();}});
        convertMain();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }


    static void convert(TextArea ARG1,Label A1L, TextArea ARG2,Label A2L, Label ANS, Button COUNT, Button CLEAR){
        ARG1.setPrefWidth(20);
        ARG1.setPrefHeight(10);
        ARG1.setStyle("-fx-border-color: black;");
        AnchorPane.setRightAnchor(ARG1, 200.0);
        AnchorPane.setLeftAnchor(ARG1,129.0);
        AnchorPane.setTopAnchor(ARG1,20.0);

        AnchorPane.setRightAnchor(A1L, 200.0);
        AnchorPane.setLeftAnchor(A1L,129.0);
        AnchorPane.setTopAnchor(A1L,70.0);

        ARG2.setPrefWidth(20);
        ARG2.setPrefHeight(10);
        ARG2.setStyle("-fx-border-color: black;");
        AnchorPane.setRightAnchor(ARG2, 120.0);
        AnchorPane.setLeftAnchor(ARG2,210.0);
        AnchorPane.setTopAnchor(ARG2,20.0);

        AnchorPane.setRightAnchor(A2L, 120.0);
        AnchorPane.setLeftAnchor(A2L,210.0);
        AnchorPane.setTopAnchor(A2L,70.0);

        ANS.setPrefWidth(90);
        ANS.setPrefHeight(30);
        ANS.setStyle("-fx-border-color: black;");
        AnchorPane.setRightAnchor(ANS, 120.0);
        AnchorPane.setLeftAnchor(ANS,120.0);
        AnchorPane.setTopAnchor(ANS,100.0);

        COUNT.setPrefWidth(60);
        COUNT.setPrefHeight(30);
        AnchorPane.setRightAnchor(COUNT, 170.0);
        AnchorPane.setLeftAnchor(COUNT,170.0);
        AnchorPane.setTopAnchor(COUNT,140.0);

        CLEAR.setPrefWidth(60);
        CLEAR.setPrefHeight(30);
        AnchorPane.setRightAnchor(CLEAR, 170.0);
        AnchorPane.setLeftAnchor(CLEAR,170.0);
        AnchorPane.setTopAnchor(CLEAR,175.0);
    }
    static void Clear(TextArea ARG1, TextArea ARG2, Label ANS){
        ARG1.clear();
        ARG2.clear();
        ANS.setText("");
    }
    static void convertMain(){
        AnchorPane.setRightAnchor(sum, 60.0);
        AnchorPane.setLeftAnchor(sum,60.0);
        AnchorPane.setTopAnchor(sum,10.0);
        AnchorPane.setRightAnchor(subtraction, 60.0);
        AnchorPane.setLeftAnchor(subtraction,60.0);
        AnchorPane.setTopAnchor(subtraction,40.0);
        AnchorPane.setRightAnchor(multiplication, 60.0);
        AnchorPane.setLeftAnchor(multiplication,60.0);
        AnchorPane.setTopAnchor(multiplication,70.0);
        AnchorPane.setRightAnchor(division, 60.0);
        AnchorPane.setLeftAnchor(division,60.0);
        AnchorPane.setTopAnchor(division,100.0);
        AnchorPane.setRightAnchor(history, 60.0);
        AnchorPane.setLeftAnchor(history,60.0);
        AnchorPane.setTopAnchor(history,130.0);
    }
}








