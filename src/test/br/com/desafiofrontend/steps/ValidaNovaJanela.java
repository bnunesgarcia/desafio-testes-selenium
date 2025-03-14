package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ValidaNovaJanela extends Utils {

    @Então("o botao {} deve esta disponivel")
    public void oBotaoDeveEstaDisponivel(String botao) {
        if(botao.equals("new window")){
            driver.findElement(By.xpath(Variaveis.newWindowBtn)).isDisplayed();
        } else if (botao.equals("add")){
            driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).isDisplayed();
        }
    }

    @E("eu clico no botao {}")
    public void euClicoNoBotao(String botao) {
        if(botao.equals("new window")){
            driver.findElement(By.xpath(Variaveis.newWindowBtn)).click();
        } else if (botao.equals("add")){
            driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
        }
    }

    @E("uma nova tela de navegador abre")
    public void umaNovaTelaDeNavegadorAbre() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    @E("eu valido a mensagem da tela")
    public void euValidoAMensagemDaTela() {
        String mensagem = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
        Assert.assertEquals("This is a sample page", mensagem);
    }


}
