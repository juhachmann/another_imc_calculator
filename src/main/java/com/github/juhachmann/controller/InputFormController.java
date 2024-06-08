package com.github.juhachmann.controller;

import com.github.juhachmann.ImcApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import com.github.juhachmann.PessoaMonostate;
import com.github.juhachmann.model.pessoa.Pessoa;
import com.github.juhachmann.model.pessoa.eSexoBiologico;
import com.github.juhachmann.utils.FormatadorDeTextoBuilder;
import com.github.juhachmann.utils.ValidacaoDeFormularioHelper;
import com.github.juhachmann.utils.Regex;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InputFormController implements Initializable {

    FormatadorDeTextoBuilder formatadorDeTexto = new FormatadorDeTextoBuilder();

    public TextField pesoControl;
    public TextField alturaControl;
    public ChoiceBox<eSexoBiologico> sexControl;
    public TextField idadeControl;
    public TextField nomeControl;

    private int submitFails = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setChoiceBoxForSex();
        this.addTextFieldFilters();
    }


    public void submit(ActionEvent actionEvent) {
        var formIsValid = this.validateForm();
        if (!formIsValid) {
            submitFails++;
            if(submitFails > 3) {
                showFailAlert();
                submitFails = 0;
            }
            return;
        }
        this.updatePessoaSingleton();
        this.updateScene();
    }

    private void showFailAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oooops");
        alert.setHeaderText(null);
        alert.setContentText("""
            Ei, há algo errado com seu formulário!
            
            Você preencheu todos os campos com valores válidos?""");
        alert.showAndWait();
    }


    private void setChoiceBoxForSex() {
        for(eSexoBiologico eSexoBiologico : eSexoBiologico.values()) {
            sexControl.getItems().add(eSexoBiologico);
        }
    }

    private void addTextFieldFilters() {
        var formatadorNome = formatadorDeTexto.fromRegex(Regex.NOME_HUMANO_GLOBAL);
        nomeControl.setTextFormatter(formatadorNome);

        int MIN_IDADE = 0;
        int MAX_IDADE = 150;
        var formatadorIdade = formatadorDeTexto.fromRegexWithRange(
                Regex.INTEIRO_POSITIVO, MIN_IDADE, MAX_IDADE);
        idadeControl.setTextFormatter(formatadorIdade);

        double MIN_PESO = 0D;
        double MAX_PESO = 600D;
        var formatadorPeso = formatadorDeTexto.fromRegexWithRange(
                Regex.DECIMAL_POSITIVO, MIN_PESO, MAX_PESO);
        pesoControl.setTextFormatter(formatadorPeso);

        double MIN_ALTURA = 0D;
        double MAX_ALTURA = 2.5;
        var formatadorAltura = formatadorDeTexto.fromRegexWithRange(
                Regex.DECIMAL_POSITIVO, MIN_ALTURA, MAX_ALTURA);
        alturaControl.setTextFormatter(formatadorAltura);

    }


    private boolean validateForm() {
        List<Control> fields = new ArrayList<>();
        fields.add(nomeControl);
        fields.add(idadeControl);
        fields.add(alturaControl);
        fields.add(pesoControl);
        fields.add(sexControl);
        return ValidacaoDeFormularioHelper.validar(fields);
    }


    private void updatePessoaSingleton() {
        var pessoa = this.createPessoaFromFormInputs();
        new PessoaMonostate().setPessoa(pessoa);
    }


    private Pessoa createPessoaFromFormInputs() {
        var name = nomeControl.getText();
        var age = Integer.parseInt(idadeControl.getText());
        var peso = Double.parseDouble(pesoControl.getText());
        var altura = Double.parseDouble(alturaControl.getText());
        var sexo = sexControl.getValue();

        return new Pessoa(name, age, peso, altura, sexo);
    }


    private void updateScene() {
        var tela_resultado = "view/result-scene.fxml";
        ImcApplication.setRoot(tela_resultado);
    }

}
