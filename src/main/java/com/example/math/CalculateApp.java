package com.example.math;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.example.math.CalculateApp.*;

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
        FlowPane root = new FlowPane(Orientation.VERTICAL, sum, division, multiplication, subtraction, history);
        Scene scene = new Scene(root, 400, 400);
        sum.setOnAction(new EventHandler<ActionEvent>(){@Override public void handle(ActionEvent actionEvent) {Summa.setSum(); primaryStage.close();}});
        division.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Division.setDiv(); primaryStage.close();}});
        multiplication.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Mult.setMult(); primaryStage.close();}});
        subtraction.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Sub.setSub();primaryStage.close();}});
        history.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {History.showHistory();}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }


    static void convert(TextArea ARG1, TextArea ARG2, Label ANS, Button COUNT, Button CLEAR){
        ARG1.setPrefWidth(20);
        ARG1.setPrefHeight(10);
        ARG1.setStyle("-fx-border-color: black;");
        ARG2.setPrefWidth(20);
        ARG2.setPrefHeight(10);
        ARG2.setStyle("-fx-border-color: black;");
        ANS.setPrefWidth(90);
        ANS.setPrefHeight(30);
        ANS.setStyle("-fx-border-color: black;");
        COUNT.setPrefWidth(60);
        COUNT.setPrefHeight(30);
        CLEAR.setPrefWidth(60);
        CLEAR.setPrefHeight(30);
    }
    static void Clear(TextArea ARG1, TextArea ARG2, Label ANS){
        ARG1.clear();
        ARG2.clear();
        ANS.setText("");
    }
}

class Summa{

    static TextArea arg1 = new TextArea();
    static TextArea arg2 = new TextArea();
    static Label ans = new Label();
    static Label name1 = new Label("Argument 1");
    static Label name2 = new Label("Argument 2");
    static Button count = new Button("Count");
    static Button clear = new Button("Clear");
    static Stage primaryStage = new Stage();
    static void setSum() {
        FlowPane root = new FlowPane(Orientation.VERTICAL, name1, arg1, name2, arg2, ans, count, clear);
        Scene scene = new Scene(root, 400, 400);

        convert(arg1, arg2, ans, count, clear);
        count.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {Summ();HISTORY.add(arg1.getText()+"+"+arg2.getText());}});
        clear.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Clear(arg1, arg2, ans);}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sum");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {@Override public void handle(WindowEvent windowEvent) {CalculateApp.setMain();}});
    }

    protected static void Summ(){
        if (Objects.equals(arg1.getText(), "") || Objects.equals(arg2.getText(), "")){
            ans.setText("Empty arg");
        }
        else {
            try{
                Double Arg1 = Double.parseDouble(arg1.getText());
                Double Arg2 = Double.parseDouble(arg2.getText());
                ans.setText("Answer: "+(Arg1+Arg2));
            }
            catch (IllegalArgumentException e){
                ans.setText("wrong input");
            }

        }
    }
}

class Division{
    static TextArea arg1 = new TextArea();
    static TextArea arg2 = new TextArea();
    static Label ans = new Label();
    static Label name1 = new Label("Argument 1");
    static Label name2 = new Label("Argument 2");
    static Button count = new Button("Count");
    static Button clear = new Button("Clear");
    static Stage primaryStage = new Stage();

    static void setDiv(){
        FlowPane root = new FlowPane(Orientation.VERTICAL, name1, arg1, name2, arg2, ans, count, clear);
        Scene scene = new Scene(root, 400, 400);

        convert(arg1, arg2, ans, count, clear);
        count.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {division();HISTORY.add(arg1.getText()+"/"+arg2.getText());}});
        clear.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Clear(arg1, arg2, ans);}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Division");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {@Override public void handle(WindowEvent windowEvent) {CalculateApp.setMain();}});
    }
    protected static void division(){
        if (Objects.equals(arg1.getText(), "") || Objects.equals(arg2.getText(), "")){
            ans.setText("Empty arg");
        }
        else {
            try{
                double Arg1 = Double.parseDouble(arg1.getText());
                double Arg2 = Double.parseDouble(arg2.getText());
                if (Arg2==0){
                    ans.setText("division by zero");
                    throw new ArithmeticException("Division by zero");}
                else
                    ans.setText("Answer: " + (Arg1/Arg2));
            }
            catch (IllegalArgumentException e){
                ans.setText("wrong input");
            }


        }
    }
}

class Mult{
    static TextArea arg1 = new TextArea();
    static TextArea arg2 = new TextArea();
    static Label ans = new Label();
    static Label name1 = new Label("Argument 1");
    static Label name2 = new Label("Argument 2");
    static Button count = new Button("Count");
    static Button clear = new Button("Clear");
    static Stage primaryStage = new Stage();

    static void setMult(){
        FlowPane root = new FlowPane(Orientation.VERTICAL, name1, arg1, name2, arg2, ans, count, clear);
        Scene scene = new Scene(root, 400, 400);

        convert(arg1, arg2, ans, count, clear);
        count.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {Multy();HISTORY.add(arg1.getText()+"*"+arg2.getText());}});
        clear.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Clear(arg1, arg2, ans);}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multiplication");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {@Override public void handle(WindowEvent windowEvent) {CalculateApp.setMain();}});
    }
    protected static void Multy(){
        if (Objects.equals(arg1.getText(), "") || Objects.equals(arg2.getText(), "")){
            ans.setText("Empty arg");
        }
        else {
            try{
                double Arg1 = Double.parseDouble(arg1.getText());
                double Arg2 = Double.parseDouble(arg2.getText());
                ans.setText("Answer: "+(Arg1*Arg2));
            }
            catch (IllegalArgumentException e){
                ans.setText("wrong input");
            }


        }
    }
}
class Sub{
    static TextArea arg1 = new TextArea();
    static TextArea arg2 = new TextArea();
    static Label ans = new Label();
    static Label name1 = new Label("Argument 1");
    static Label name2 = new Label("Argument 2");
    static Button count = new Button("Count");
    static Button clear = new Button("Clear");
    static Stage primaryStage = new Stage();

    static void setSub() {
        FlowPane root = new FlowPane(Orientation.VERTICAL, name1, arg1, name2, arg2, ans, count, clear);
        Scene scene = new Scene(root, 400, 400);

        convert(arg1, arg2, ans, count, clear);
        count.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {SubC();HISTORY.add(arg1.getText()+"-"+arg2.getText());}});
        clear.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Clear(arg1, arg2, ans);}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multiplication");
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {@Override public void handle(WindowEvent windowEvent) {CalculateApp.setMain();}});
    }
    protected static void SubC(){
        if (Objects.equals(arg1.getText(), "") || Objects.equals(arg2.getText(), "")){
            ans.setText("Empty arg");
        }
        else {
            try{
                double Arg1 = Double.parseDouble(arg1.getText());
                double Arg2 = Double.parseDouble(arg2.getText());
                ans.setText("Answer: "+(Arg1-Arg2));
            }
            catch (IllegalArgumentException e){
                ans.setText("wrong input");
            }


        }
    }
}

class History{
    static Stage stage = new Stage();
    static String HISToRY = String.join(",", HISTORY);
    static void showHistory(){
            Text Hist = new Text(HISTORY.toString());
            Hist.setFont(Font.font("Arial", 24));
            FlowPane pane = new FlowPane(Orientation.VERTICAL,Hist);
            Scene scene = new Scene(pane, 400,400);
            stage.setScene(scene);
            stage.setTitle("History");
            stage.show();





    }
}