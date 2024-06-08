package org.example.controller;

import atlantafx.base.controls.ToggleSwitch;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.example.ImcApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class TopBarController implements Initializable {

    public ToggleSwitch darkModeSwitchBtn;
    public Text themeText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(ImcApplication.darkMode) {
            darkModeSwitchBtn.setSelected(true);
            setDarkMode();

        } else {
            darkModeSwitchBtn.setSelected(false);
            setLightMode();
        }
    }


    public void toggleSwitch(MouseEvent mouseEvent) {
        if (darkModeSwitchBtn.isSelected()) {
            setDarkMode();
        } else {
            setLightMode();
        }
    }


    private void setDarkMode() {
        Application.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());
        themeText.setText("Modo Escuro");
        ImcApplication.darkMode = true;
    }

    private void setLightMode() {
        Application.setUserAgentStylesheet(new NordLight().getUserAgentStylesheet());
        themeText.setText("Modo Claro");
        ImcApplication.darkMode = false;
    }

}
