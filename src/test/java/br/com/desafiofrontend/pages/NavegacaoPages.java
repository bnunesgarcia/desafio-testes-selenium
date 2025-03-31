package br.com.desafiofrontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;

public class NavegacaoPages extends Utils {
    public void validaExibicaoMenu(String menu) {
        if (menu.equals("forms")) {
            driver.findElement(By.xpath(Variaveis.menuForms)).isDisplayed();
        } else if (menu.equals("alerts, frame & windows")) {
            driver.findElement(By.xpath(Variaveis.menuAlerts)).isDisplayed();
        } else if (menu.equals("elements")) {
            driver.findElement(By.xpath(Variaveis.menuElements)).isDisplayed();
        } else if (menu.equals("interactions")) {
            driver.findElement(By.xpath(Variaveis.menuInteractions)).isDisplayed();
        } else if (menu.equals("widgets")) {
            driver.findElement(By.xpath(Variaveis.widgets)).isDisplayed();
        } else if (menu.equals("book store application")) {
            driver.findElement(By.xpath(Variaveis.menuBookStoreApplication)).isDisplayed();
        }
    }

    public void acessaMenu(String menu) {
        if (menu.equals("forms")) {
            driver.findElement(By.xpath(Variaveis.menuForms)).click();
        } else if (menu.equals("alerts, frame & windows")) {
            driver.findElement(By.xpath(Variaveis.menuAlerts)).click();
        } else if (menu.equals("elements")) {
            driver.findElement(By.xpath(Variaveis.menuElements)).click();
        } else if (menu.equals("interactions")) {
            driver.findElement(By.xpath(Variaveis.menuInteractions)).click();
        } else if (menu.equals("widgets")) {
            driver.findElement(By.xpath(Variaveis.widgets)).click();
        } else if (menu.equals("book store application")) {
            driver.findElement(By.xpath(Variaveis.menuBookStoreApplication)).click();
        }
    }

    public void validaSubMenu(String menu) {
        List<String> submenus = Variaveis.getSubmenus(menu);
        for (String submenu : submenus) {
            String submenuXpath = "//span[@class='text' and text()='" + submenu + "']";
            if (driver.findElement(By.xpath(submenuXpath)).isDisplayed()) {
                System.out.println("Submenu " + submenu + " OK!");
            }
        }
    }

    public void acessaSubMenu(String submenu) {
        if (submenu.equals("web tables")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement webTablesElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Variaveis.subMenuWebElements)));
            webTablesElement.click();
        } else if(submenu.equals("login")){
            WebElement element = driver.findElement(By.cssSelector(Variaveis.subMenuLogin));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void acessarOperacao(String operacao) {
        if(operacao.equals("adicionar")){
            driver.findElement(By.xpath(Variaveis.botaoAddNovoRegistro)).click();
        } else if(operacao.equals("editar")){
            driver.findElement(By.xpath(Variaveis.botaoEditaRegistro)).click();
        } else if(operacao.equals("deletar")){
            driver.findElement(By.xpath(Variaveis.botaoDeletaRegistro)).click();
        }
    }

    public void realizarOperacao(String acao) throws InterruptedException{
        if(acao.equals("preencho")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            driver.findElement(By.id(Variaveis.campoNome)).sendKeys("Bruno");
            driver.findElement(By.id(Variaveis.campoSobrenome)).sendKeys("Teste");
            driver.findElement(By.id(Variaveis.campoEmail)).sendKeys("teste@teste.com.br");
            driver.findElement(By.id(Variaveis.campoIdade)).sendKeys("36");
            driver.findElement(By.id(Variaveis.campoSalario)).sendKeys("5000");
            driver.findElement(By.id(Variaveis.campoDepto)).sendKeys("TI");
            driver.findElement(By.xpath(Variaveis.botaoSubmitFormulario)).click();
        } else if(acao.equals("altero")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            WebElement campoNome = driver.findElement(By.id(Variaveis.campoNome));
            campoNome.clear();
            campoNome.sendKeys("Alteracao");
            driver.findElement(By.xpath(Variaveis.botaoSubmitFormulario)).click();
        } else if(acao.equals("excluo")){
            while (true) {
                List<WebElement> deleteButtons = driver.findElements(By.xpath("//*[contains(@id, 'delete-record-')]"));
                if (deleteButtons.isEmpty()) {
                    break;
                }
                deleteButtons.get(0).click();
                Thread.sleep(1000);
            }
        }
    }

    public void validaAcao(String tipoOper) {
        switch (tipoOper.toLowerCase()) {
            case "criacao":
                validarElemento(".rt-tr-group:nth-of-type(4) .rt-td:first-of-type", "Bruno");
                break;
            case "alteracao":
                validarElemento(".rt-td[role=\"gridcell\"]:nth-of-type(1)", "Alteracao");
                break;
            case "exclusao":
                pesquisaNegativaDeRegistros();
                break;
            default:
                throw new IllegalArgumentException("Tipo de operação não suportado: " + tipoOper);
        }
    }

    public void pesquisaRegistro(String registro){
        driver.findElement(By.xpath(Variaveis.campoPesquisa)).sendKeys(registro);
    }

    public void validaPesquisa(String registro){
        for (String[] valores : Variaveis.REGISTROS) {
            if (registro.equals(valores[0])) {
                validarElementos(valores);
                break;
            }
        }
    }       

    public void pesquisaNegativaDeRegistros(){
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[3]"));
            String elementoNegativo = element.getText();
            Assert.assertEquals(elementoNegativo, "No rows found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validarElementos(String[] expectedValues) {
        List<WebElement> elements = driver.findElements(By.cssSelector("div.rt-td"));
        for (int i = 1; i < expectedValues.length; i++) {
            String actualText = elements.get(i - 1).getText();
            if (actualText.equals(expectedValues[i])) {
                System.out.println("Elemento " + i + " esta correto: " + actualText);
            } else {
                System.out.println("Elemento " + i + " esta incorreto: " + actualText);
            }
        }
    }

    private void validarElemento(String cssSelector, String valorEsperado) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
            String elemento = element.getText();
            Assert.assertEquals(elemento, valorEsperado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
