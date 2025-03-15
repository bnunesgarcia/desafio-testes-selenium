package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.support.Utils;
import io.cucumber.java.pt.E;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EditarRegistros extends Utils {

    @E("eu acesso a tela de editar dados")
    public void euAcessoATelaDeEditarDados() {
        WebElement editBtn = driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
    }

    @E("eu altero o nome para {}")
    public void euEditoONome(String nomeAlterado) {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(nomeAlterado);
    }

    @E("eu altero o sobrenome para {}")
    public void euEditoOSobrenome(String sobrenomeAlterado) {
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(sobrenomeAlterado);
    }
    @E("eu realizo o submit da alteracao do registro")
    public void euRealizoAlteracaoDoRegistro() {
        driver.findElement(By.id("submit")).click();
    }

    @E("eu valido que os dados foram alterados corretamente")
    public void euValidoQueOsDadosForamAlteradosCorretamente() {
        String nomeAtual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
        String sobrenomeAtual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]")).getText();
        String nomeEsperado = "Gael";
        String sobrenomeEsperado = "Garcia";
        Assert.assertEquals(nomeAtual, nomeEsperado);
        Assert.assertEquals(sobrenomeAtual, sobrenomeEsperado);
    }


}
