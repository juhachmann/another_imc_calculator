package com.github.juhachmann.controller;

import com.github.juhachmann.ImcApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import com.github.juhachmann.PessoaMonostate;
import com.github.juhachmann.model.imc.CalculadoraImc;
import com.github.juhachmann.model.imc.ClassificadorImcFactory;
import com.github.juhachmann.model.imc.exception.ClassificadorNaoEncontradoException;
import com.github.juhachmann.model.imc.eClassificacaoIMC;
import com.github.juhachmann.model.pessoa.Pessoa;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {

    public Text classificacaoText;
    public Text imcText;
    public Text categoriaText;
    public HBox categoriaBox;
    public VBox mainBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pessoa pessoa = new PessoaMonostate().getPessoa();

        var imc = CalculadoraImc.calcular(pessoa.getPeso(),pessoa.getAltura());
        imcText.setText("%.2f".formatted(imc));

        classificacaoText.getStyleClass().add("text");

        try {
            var classificadorIMC = ClassificadorImcFactory.create(pessoa);
            var classificacao = classificadorIMC.classificar(imc);

            classificacaoText.setText(classificacao.getName().toUpperCase());
            var colorStyle = this.getColorForClassificacao(classificacao);
            classificacaoText.getStyleClass().add("text-bold");
            classificacaoText.getStyleClass().add(colorStyle);
            categoriaText.setText(classificadorIMC.getCategoria());

        } catch (IllegalArgumentException | ClassificadorNaoEncontradoException ex) {
            classificacaoText.getStyleClass().add("warning");
            classificacaoText.setText("""                    
                    Não foi possível calcular a classificação!
                    
                    No momento, só classificamos para:
                    - crianças entre 6 e 15 anos
                    - adultos maiores de 18 anos
                    
                    Procure seu médico para maiores informações.""");
            classificacaoText.getStyleClass().remove("title-4");
            categoriaBox.setVisible(false);
            mainBox.setSpacing(10.0);
        }

    }

    public void reset(ActionEvent actionEvent) {
        ImcApplication.setRoot("view/input-scene.fxml");
    }

    private String getColorForClassificacao(eClassificacaoIMC classificacao) {
        return switch (classificacao) {
            case ABAIXO, OBESIDADE, OBESIDADE_GRAVE -> "danger";
            case SOBREPESO -> "warning";
            default -> "success";
        };
    }

}
