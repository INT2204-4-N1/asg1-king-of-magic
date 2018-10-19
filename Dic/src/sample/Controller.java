package sample;

import application.TextToSpeech;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.EV.TranslateEV;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Controller {

    public Controller(){
        System.out.println("runing");
    }
    private String filePathEtoV = "src/Data/anhviet109K.index";
    private String dataPathEtoV = "src/Data/anhviet109K.dict";
    private String filePathVtoE = "src/Data/vietanh.index";
    private String dataPathVtoE = "src/Data/vietanh.dict";
    private TranslateEV test;

    @FXML
    public void initialize() {
        System.out.println("initialized");
        if(cbEtoV.isSelected()) {
            test = new TranslateEV(filePathEtoV,dataPathEtoV);
        }
        if(cbVtoE.isSelected()) {
            test = new TranslateEV(filePathVtoE,dataPathVtoE);
        }
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-size: 15");

        Speaker.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Speaker pressed ");
            TextToSpeech test = new TextToSpeech();
            test.speak(textField.getText(),1.0f,true,false);

            event.consume();
        });

    }

    @FXML
    private TextField textField;
    public void searchButton(ActionEvent event) {
        String key = textField.getText();
        test.englishToVietnameseOn(key);
        System.out.println(test.map);
        textArea.clear();
        if(test.founded == false) {
            textArea.setStyle("-fx-font-size: 30");
            if(cbEtoV.isSelected()){
                textArea.setText("\nNo value.\nOr changes kind of translate.");
            } else {
                textArea.setText("Không có dữ liệu.\nHoặc hãy chuyển đổi kiểu dịch.");
            }
        } else {
            textArea.setStyle("-fx-font-size: 15");
            textArea.setText("\n\n" + test.map.get(textField.getText()));
        }


    }

    @FXML
    public CheckBox cbEtoV,cbVtoE;
    public void checkEventEtoV(ActionEvent e){
        if(cbEtoV.isSelected()) {
            cbVtoE.setSelected(false);
            test = new TranslateEV(filePathEtoV,dataPathEtoV);
        }
    }
    public void checkEventVtoE(ActionEvent e){
        if(cbVtoE.isSelected()) {
            cbEtoV.setSelected(false);
            test = new TranslateEV(filePathVtoE,dataPathVtoE);
        }
    }
    @FXML
    private TextArea textArea;

    @FXML
    public void onEnter(ActionEvent ae){
        searchButton(ae);
    }

    @FXML
    private ImageView Speaker;








}
