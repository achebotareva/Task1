package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TimeCalculator extends Application {


    public Button calculate;
    public Button clean;
    public Button exit;
    public TextArea result_field;
    public Text timeLabel;
    public TextField first_field;
    public TextField second_field;
    public Text timeLabel1;
    private String massages = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeCalculator.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Calculator of Time");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (first_field.getText().compareTo("") != 0 && second_field.getText().compareTo("") != 0) {
                    if(first_field.getText().split(":").length < 2 || second_field.getText().split(":").length < 2){
                        massages = "Please, enter the correct times!!!";
                        result_field.setText(massages);
                        massages = "";
                    }
                    else {
                        MyTime first_time = new MyTime(first_field.getText());
                        MyTime second_time = new MyTime(second_field.getText());

                        massages += first_time.toString() + " + " + second_time.toString() + " = " + first_time.plus(second_time).toString() + "\n";
                        massages += first_time.toString() + " - " + second_time.toString() + " = " + first_time.sub(second_time).toString() + "\n";
                        if (first_time.compare(second_time) > 0) {
                            massages += first_time.toString() + " > " + second_time.toString() + "\n";
                        } else if (first_time.compare(second_time) < 0) {
                            massages += first_time.toString() + " < " + second_time.toString() + "\n";
                        } else {
                            massages += first_time.toString() + " = " + second_time.toString() + "\n";
                        }
                        result_field.setText(massages);
                    }
                }
                else {
                    massages = "Please, enter the times!!!";
                    result_field.setText(massages);
                    massages = "";
                }
            }
        });

        clean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                massages = "";
                result_field.setText(massages);
            }
        });


        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }

}
