package br.com.desafiofrontend.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import java.time.Duration;
import java.util.NoSuchElementException;
import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;

public class LoginPages extends Utils {

    public void acessaTelaNovoUsuario(){
        driver.findElement(By.xpath(Variaveis.botaoTelaNewUser)).click();
    }

    public void cadastraNovoUsuario() throws InterruptedException{
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = "Teste" + faker.number().digits(3);
        String password = "Teste@" + faker.number().digits(4);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement recaptchaFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@src, 'recaptcha')]")));
        driver.switchTo().frame(recaptchaFrame);
        WebElement recaptchaContainer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor']")));
        if (recaptchaContainer.isDisplayed()) {
            recaptchaContainer.click();
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(Variaveis.campoFirstName)).sendKeys(firstName);
        driver.findElement(By.xpath(Variaveis.campoLastName)).sendKeys(lastName);
        driver.findElement(By.xpath(Variaveis.campoUserName)).sendKeys(userName);
        driver.findElement(By.xpath(Variaveis.campoPassword)).sendKeys(password);

        try {
            WebElement adIframe = driver.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", adIframe);
        } catch (NoSuchElementException e) {

        }
        WebElement registerButton = driver.findElement(By.xpath(Variaveis.botaoRegistrar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
        // Thread.sleep(10000);
    }

    public void realizarLogin(){
        driver.findElement(By.xpath(Variaveis.campoUserName)).isDisplayed();
        driver.findElement(By.xpath(Variaveis.campoUserName)).sendKeys("TesteBru");
        driver.findElement(By.xpath(Variaveis.campoPassword)).sendKeys("Teste@1000");
        driver.findElement(By.xpath(Variaveis.botaoLogin)).click();
        WebElement nomeUsuarioLogado = driver.findElement(By.xpath(Variaveis.containerNomeUser));
        String elemento = nomeUsuarioLogado.getText();
        Assert.assertEquals(elemento, "TesteBru");
    }

    public void realizaLogout(){
        driver.findElement(By.xpath(Variaveis.botaoLogout)).isDisplayed();
        driver.findElement(By.xpath(Variaveis.botaoLogout)).click();
    }

    public void realizarLoginNegativo(String motivo_erro){
        if(motivo_erro.equals("senha invalida")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Variaveis.campoUserName)));
            driver.findElement(By.xpath(Variaveis.campoUserName)).sendKeys("TesteBru");
            driver.findElement(By.xpath(Variaveis.campoPassword)).sendKeys("teste");
            driver.findElement(By.xpath(Variaveis.botaoLogin)).click();
        } else if(motivo_erro.equals("usuario invalido")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Variaveis.campoUserName)));
            driver.findElement(By.xpath(Variaveis.campoUserName)).sendKeys("userInv");
            driver.findElement(By.xpath(Variaveis.campoPassword)).sendKeys("Teste@2000");
            driver.findElement(By.xpath(Variaveis.botaoLogin)).click();
        }
    }

    public void validaFalhaNoLogin(String motivo_erro, String mensagem){
        if(motivo_erro.equals("senha invalida")){
            WebElement mensagemContainer = driver.findElement(By.xpath(Variaveis.containerMensagem));
            String elemento = mensagemContainer.getText();
            Assert.assertEquals(elemento, mensagem);
        } else if(motivo_erro.equals("usuario invalido")){
            WebElement mensagemContainer = driver.findElement(By.xpath(Variaveis.containerMensagem));
            String elemento = mensagemContainer.getText();
            Assert.assertEquals(elemento, mensagem);
        }
    }
}
