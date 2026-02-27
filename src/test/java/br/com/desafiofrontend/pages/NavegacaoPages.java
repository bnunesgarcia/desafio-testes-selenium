package br.com.desafiofrontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.desafiofrontend.support.Utils;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

public class NavegacaoPages extends Utils {

    public NavegacaoPages() {
    PageFactory.initElements(driver, this);
    }

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

    @FindBy(css = "a[href='/forms']")
    private WebElement menuForms;
    @FindBy(css = "a[href='/alertsWindows']")
    private WebElement menuAlerts;
    @FindBy(css = "a[href='/elements']")
    private WebElement menuElements;
    @FindBy(css = "a[href='/interaction']")
    private WebElement menuInteractions;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/a[6]")    
    private WebElement menuBookStoreApplication;
    @FindBy(css = "a[href='/widgets']")
    private WebElement menuWidgets;
    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement subMenuWebElements;
    @FindBy(xpath = "//span[text()='Sortable']")
    private WebElement subMenuSortable;
    @FindBy(xpath = "//div[2]/div/div/div/div[1]/div/div/div[2]/div/ul")
    private WebElement subMenuPracticeFroms;
    @FindBy(css = ".show > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)")
    private WebElement subMenuBrowserWindows;
    @FindBy(css = ".show > ul:nth-child(1) > li:nth-child(1)")
    private WebElement subMenuLogin;
    @FindBy(id = "searchBox")
    private WebElement campoPesquisa;
    @FindBy(id = "addNewRecordButton")
    private WebElement botaoAddNovoRegistro;
    @FindBy(id = "edit-record-1")
    private WebElement botaoEditaRegistro;
    @FindBy(id = "delete-record-1")
    private WebElement botaoDeletaRegistro;
    @FindBy(id = "firstName")
    private WebElement campoNome;
    @FindBy(id = "lastName")
    private WebElement campoSobrenome;
    @FindBy(id = "userEmail")
    private WebElement campoEmail;
    @FindBy(id = "age")
    private WebElement campoIdade;
    @FindBy(id = "salary")
    private WebElement campoSalario;
    @FindBy(id = "department")
    private WebElement campoDepto;
    @FindBy(id = "submit")
    private WebElement botaoSubmitFormulario;

    public void validaExibicaoMenu(String menu) {
        if (menu.equals("forms")) {
            menuForms.isDisplayed();
        } else if (menu.equals("alerts, frame & windows")) {
            menuAlerts.isDisplayed();
        } else if (menu.equals("elements")) {
            menuElements.isDisplayed();
        } else if (menu.equals("interactions")) {
            menuInteractions.isDisplayed();
        } else if (menu.equals("widgets")) {
            menuWidgets.isDisplayed();
        } else if (menu.equals("book store application")) {
            menuBookStoreApplication.isDisplayed();
        }
    }

    public void acessaMenu(String menu) {
        if (menu.equals("forms")) {
            menuForms.click();
        } else if (menu.equals("alerts, frame & windows")) {
            menuAlerts.click();
        } else if (menu.equals("elements")) {
            menuElements.click();
        } else if (menu.equals("interactions")) {
            menuInteractions.click();
        } else if (menu.equals("widgets")) {
            menuWidgets.click();
        } else if (menu.equals("book store application")) {
            menuBookStoreApplication.click();
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
        // Para submenus específicos que exigem tratativa especial
        String xpathDinamico = "//span[@class='text' and text()='" + submenu + "']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDinamico)));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void acessarOperacao(String operacao) {
        if(operacao.equals("adicionar")){
            botaoAddNovoRegistro.click();
        } else if(operacao.equals("editar")){
            botaoEditaRegistro.click();
        } else if(operacao.equals("deletar")){
            botaoDeletaRegistro.click();
        }
    }

    public void realizarOperacao(String acao) throws InterruptedException{
        if(acao.equals("preencho")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            campoNome.sendKeys("Bruno");
            campoSobrenome.sendKeys("Teste");
            campoEmail.sendKeys("teste@teste.com.br");
            campoIdade.sendKeys("36");
            campoSalario.sendKeys("5000");
            campoDepto.sendKeys("TI");
            botaoSubmitFormulario.click();
        } else if(acao.equals("altero")){
            driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
            campoNome.clear();
            campoNome.sendKeys("Alteracao");
            botaoSubmitFormulario.click();
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
        campoPesquisa.sendKeys(registro);
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
