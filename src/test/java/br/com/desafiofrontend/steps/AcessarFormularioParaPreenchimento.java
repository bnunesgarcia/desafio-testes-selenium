package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.pages.AcessaFuncionalidadesPages;
import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import io.cucumber.java.pt.*;
import org.openqa.selenium.By;

public class AcessarFormularioParaPreenchimento extends Utils {

    AcessaFuncionalidadesPages validaMenu = new AcessaFuncionalidadesPages();

    @Dado("que eu acesse a aplicacao demoqa")
    public void queEuAcesseAAplicacaoDemoqa() {
        acessarAplicacao();
    }


    @E("o formulario para preenchimento deve ser disponibilizado")
    public void oFormularioParaPreenchimentoDeveSerDisponibilizado() {
        driver.findElement(By.xpath(Variaveis.formulario)).isDisplayed();
    }
}

