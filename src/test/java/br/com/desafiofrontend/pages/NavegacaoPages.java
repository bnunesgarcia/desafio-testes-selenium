package br.com.desafiofrontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.desafiofrontend.support.Utils;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

public class NavegacaoPages extends Utils {

    List<String> getSubmenus(String menu) {
        switch (menu.toLowerCase()) {
            case "elements":
                return Arrays.asList("Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties");
            case "forms":
                return Arrays.asList("Practice Form");
            case "alerts, frame & windows":
                return Arrays.asList("Browser Windows", "Alerts", "Frames", "Nested Frames", "Modal Dialogs");
            case "widgets":
                return Arrays.asList("Accordian", "Auto Complete", "Date Picker", "Slider", "Progress Bar", "Tabs", "Tool Tips", "Menu", "Select Menu");
            case "interactions":
                return Arrays.asList("Sortable", "Selectable", "Resizable", "Droppable", "Dragabble");
            case "book store application":
                return Arrays.asList("Login", "Book Store", "Profile", "Book Store API");
            default:
                return Arrays.asList();
        }
    }

    String[][] REGISTROS = {
        {"Vega", "Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance"},
        {"Cantrell", "Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance"},
        {"Gentry", "Kierra", "Gentry", "29", "kierra@example.com", "2000", "Legal"}
    };

    String menuForms = "//div[2]/div/div/div[2]/div/div[2]";
    String menuAlerts = "//div[2]/div/div/div[2]/div/div[3]";
    String menuElements = "//div[2]/div/div/div[2]/div/div[1]";
    String widgets = "//div[2]/div/div/div[2]/div/div[4]";
    String menuInteractions = "//div[2]/div/div/div[2]/div/div[5]";
    String menuBookStoreApplication = "//div[2]/div/div/div[2]/div/div[6]";
    String subMenuPracticeForms = "//div[2]/div/div/div/div[1]/div/div/div[2]/div/ul";
    String subMenuBrowserWindows = ".show > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)";
    String subMenuWebElements = ".show > ul:nth-child(1) > li:nth-child(4) > span:nth-child(2)";
    String subMenuSortable = ".show > ul:nth-child(1) > li:nth-child(1)";
    String subMenuLogin = ".show > ul:nth-child(1) > li:nth-child(1)";
    String campoPesquisa = "//*[@id=\"searchBox\"]";
    String botaoAddNovoRegistro = "//*[@id=\"addNewRecordButton\"]";
    String botaoEditaRegistro = "//*[@id=\"edit-record-1\"]";
    String botaoDeletaRegistro = "//*[@id=\"delete-record-1\"]";
    String campoNome = "firstName";
    String campoSobrenome = "lastName";
    String campoEmail = "userEmail";
    String campoIdade = "age";
    String campoSalario = "salary";
    String campoDepto = "department";
    String botaoSubmitFormulario = "//*[@id=\"submit\"]";

    public void validaExibicaoMenu(String menu) {
        if (menu.equals("forms")) {
            driver.findElement(By.xpath(menuForms)).isDisplayed();
        } else if (menu.equals("alerts, frame & windows")) {
            driver.findElement(By.xpath(menuAlerts)).isDisplayed();
        } else if (menu.equals("elements")) {
            driver.findElement(By.xpath(menuElements)).isDisplayed();
        } else if (menu.equals("interactions")) {
            driver.findElement(By.xpath(menuInteractions)).isDisplayed();
        } else if (menu.equals("widgets")) {
            driver.findElement(By.xpath(widgets)).isDisplayed();
        } else if (menu.equals("book store application")) {
            driver.findElement(By.xpath(menuBookStoreApplication)).isDisplayed();
        }
    }

    public void acessaMenu(String menu) {
        if (menu.equals("forms")) {
            driver.findElement(By.xpath(menuForms)).click();
        } else if (menu.equals("alerts, frame & windows")) {
            driver.findElement(By.xpath(menuAlerts)).click();
        } else if (menu.equals("elements")) {
            driver.findElement(By.xpath(menuElements)).click();
        } else if (menu.equals("interactions")) {
            driver.findElement(By.xpath(menuInteractions)).click();
        } else if (menu.equals("widgets")) {
            driver.findElement(By.xpath(widgets)).click();
        } else if (menu.equals("book store application")) {
            driver.findElement(By.xpath(menuBookStoreApplication)).click();
        }
    }

    public void validaSubMenu(String menu) {
        List<String> submenus = getSubmenus(menu);
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
            WebElement webTablesElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(subMenuWebElements)));
            webTablesElement.click();
        } else if(submenu.equals("login")){
            WebElement element = driver.findElement(By.cssSelector(subMenuLogin));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void acessarOperacao(String operacao) {
        if(operacao.equals("adicionar")){
            driver.findElement(By.xpath(botaoAddNovoRegistro)).click();
        } else if(operacao.equals("editar")){
            driver.findElement(By.xpath(botaoEditaRegistro)).click();
        } else if(operacao.equals("deletar")){
            driver.findElement(By.xpath(botaoDeletaRegistro)).click();
        }
    }

    public void realizarOperacao(String acao) throws InterruptedException{
        if(acao.equals("preencho")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            driver.findElement(By.id(campoNome)).sendKeys("Bruno");
            driver.findElement(By.id(campoSobrenome)).sendKeys("Teste");
            driver.findElement(By.id(campoEmail)).sendKeys("teste@teste.com.br");
            driver.findElement(By.id(campoIdade)).sendKeys("36");
            driver.findElement(By.id(campoSalario)).sendKeys("5000");
            driver.findElement(By.id(campoDepto)).sendKeys("TI");
            driver.findElement(By.xpath(botaoSubmitFormulario)).click();
        } else if(acao.equals("altero")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            WebElement campoNomeAlteracao = driver.findElement(By.id(campoNome));
            campoNomeAlteracao.clear();
            campoNomeAlteracao.sendKeys("Alteracao");
            driver.findElement(By.xpath(botaoSubmitFormulario)).click();
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
        driver.findElement(By.xpath(campoPesquisa)).sendKeys(registro);
    }

    public void validaPesquisa(String registro){
        for (String[] valores : REGISTROS) {
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
