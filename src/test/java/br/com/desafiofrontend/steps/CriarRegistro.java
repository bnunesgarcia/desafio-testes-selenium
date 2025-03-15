package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.pages.CriarMultiplosRegistrosPages;
import br.com.desafiofrontend.pages.CriarRegistroPages;
import br.com.desafiofrontend.support.Utils;
import io.cucumber.java.pt.E;
import org.openqa.selenium.By;

public class CriarRegistro extends Utils {

    CriarRegistroPages criarRegistros = new CriarRegistroPages();
    CriarMultiplosRegistrosPages criarMultiplosRegistros = new CriarMultiplosRegistrosPages();

    @E("um popup para preenchimento de novo registro aparece")
    public void umPopupParaPreenchimentoDeNovoRegistroAparece() {
        criarRegistros.validaModal();
    }

    @E("eu preencho a informacao de Nome com {}")
    public void euPreenchoONome(String nome) {
        criarRegistros.preencheNome(nome);
    }

    @E("eu preencho a informacao de sobrenome com {}")
    public void euPreenchoOSobrenome(String sobrenome) {
        criarRegistros.preencheSobrenome(sobrenome);
    }

    @E("eu preencho a informacao de email com {}")
    public void euPreenchoOEmail(String email) {
        criarRegistros.preencheEmail(email);
    }

    @E("eu preencho a informacao de idade com {}")
    public void euPreenchoAIdade(String idade) {
        criarRegistros.preencheIdade(idade);
    }

    @E("eu preencho a informacao de salario com {}")
    public void euPreenchoOSalario(String salario) {
        criarRegistros.preencheSalario(salario);
    }

    @E("eu preencho a informacao de departamento com {}")
    public void euPreenchoODepartamento(String departamento) {
        criarRegistros.preencheDepartamento(departamento);
    }

    @E("eu realizo o submit da criacao do novo registro")
    public void euRealizoOSubmitDaCriacaoDoNovoRegistro() {
        driver.findElement(By.id("submit")).click();
    }

    @E("eu valido que os dados foram inseridos na tabela de registros")
    public void euValidoQueOsDadosForamInseridosNaTabelaDeRegistros() {
        criarRegistros.validaRegistrosNaTabela();
    }


}

