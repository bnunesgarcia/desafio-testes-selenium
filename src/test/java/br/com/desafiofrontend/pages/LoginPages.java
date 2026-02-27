package br.com.desafiofrontend.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import java.time.Duration;
import java.util.NoSuchElementException;
import br.com.desafiofrontend.support.Utils;

public class LoginPages extends Utils {

    @FindBy(id = "newUser")
    private WebElement botaoTelaNewUser;
    @FindBy(id = "firstname")
    private WebElement campoFirstName;
    @FindBy(id = "lastname")
    private WebElement campoLastName;
    @FindBy(id = "userName")
    private WebElement campoUserName;
    @FindBy(id = "password")
    private WebElement campoPassword;
    @FindBy(id = "register")
    private WebElement botaoRegistrar;
    @FindBy(id = "login")
    private WebElement botaoLogin;
    @FindBy(id = "submit")
    private WebElement botaoLogout;
    @FindBy(id = "name")
    private WebElement containerMensagem;
    @FindBy(id = "userName-value")
    private WebElement containerNomeUser;

    public LoginPages() {
        PageFactory.initElements(driver, this);
    }

    public void acessaTelaNovoUsuario(){
        botaoTelaNewUser.click();
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
        campoFirstName.sendKeys(firstName);
        campoLastName.sendKeys(lastName);
        campoUserName.sendKeys(userName);
        campoPassword.sendKeys(password);

        try {
            WebElement adIframe = driver.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", adIframe);
        } catch (NoSuchElementException e) {

        }
        WebElement registerButton = botaoRegistrar;
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
        // Thread.sleep(10000);
    }

    public void realizarLogin(){
        campoUserName.isDisplayed();
        campoUserName.sendKeys("TesteBru");
        campoPassword.sendKeys("Teste@1000");
        botaoLogin.click();
        WebElement nomeUsuarioLogado = containerNomeUser;
        String elemento = nomeUsuarioLogado.getText();
        Assert.assertEquals(elemento, "TesteBru");
    }

    public void realizaLogout(){
        botaoLogout.isDisplayed();
        botaoLogout.click();
    }

    public void realizarLoginNegativo(String motivo_erro) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(campoUserName));

        if (motivo_erro.equals("senha invalida")) {
            campoUserName.sendKeys("TesteBru");
            campoPassword.sendKeys("teste");
        } else if (motivo_erro.equals("usuario invalido")) {
            campoUserName.sendKeys("userInv");
            campoPassword.sendKeys("Teste@2000");
        }
        botaoLogin.click();
    }

    public void validaFalhaNoLogin(String motivo_erro, String mensagem){
        if(motivo_erro.equals("senha invalida")){
            WebElement mensagemContainer = containerMensagem;
            String elemento = mensagemContainer.getText();
            Assert.assertEquals(elemento, mensagem);
        } else if(motivo_erro.equals("usuario invalido")){
            WebElement mensagemContainer = containerMensagem;
            String elemento = mensagemContainer.getText();
            Assert.assertEquals(elemento, mensagem);
        }
    }
}
