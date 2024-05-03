package com.example.math;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Objects;

import static com.example.math.CalculateApp.*;

public class Sub{
    static TextArea arg1 = new TextArea();
    static TextArea arg2 = new TextArea();
    static Label ans = new Label();
    static Label name1 = new Label("Argument 1");
    static Label name2 = new Label("Argument 2");
    static Button count = new Button("Count");
    static Button clear = new Button("Clear");
    static Stage primaryStage = new Stage();

    static void setSub() {
        AnchorPane root = new AnchorPane( name1, arg1, name2, arg2, ans, count, clear);
        Scene scene = new Scene(root, 400, 250);

        convert(arg1,name1, arg2,name2, ans, count, clear);
        count.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {SubC();HISTORY.add(arg1.getText()+"-"+arg2.getText());}});
        clear.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent actionEvent) {Clear(arg1, arg2, ans);}});
        primaryStage.setScene(scene);
        primaryStage.setTitle("Subtraction");
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
