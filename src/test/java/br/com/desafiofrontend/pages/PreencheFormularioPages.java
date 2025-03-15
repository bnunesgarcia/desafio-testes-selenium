package br.com.desafiofrontend.pages;

import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PreencheFormularioPages extends Utils {

    public void preencheFirstName(){
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Variaveis.nomeFake);
    }

    public void preencheLastName(){
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Variaveis.sobrenomeFake);
    }

    public void preencheEmail(){
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Variaveis.emailFake);
    }

    public void selecionaGender(String gender){
        if (gender.equals("masculino")){
            WebElement masculinoRadioBtn = driver.findElement(By.id("gender-radio-1"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", masculinoRadioBtn);
        } else if (gender.equals("feminino")){
            WebElement femininoRadioBtn = driver.findElement(By.id("gender-radio-2"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", femininoRadioBtn);
        } else if (gender.equals("outros")){
            WebElement outrosRadioBtn = driver.findElement(By.id("gender-radio-3"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", outrosRadioBtn);
        }
    }

    public void preencheTelefone(){
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(Variaveis.numeroFake);
    }

    public void selecionaDataNascimento(){
        WebElement campoDataNascimento = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(campoDataNascimento).sendKeys("20 Jun 88");
    }

    public void selecionaSubject(){

    }

    public void selecionaHobbie(String hobbie){
        if (hobbie.equals("sports")){
            WebElement sportsHobbie = driver.findElement(By.xpath(Variaveis.sports));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsHobbie);
        } else if (hobbie.equals("reading")){
            WebElement readingHobbie = driver.findElement(By.xpath(Variaveis.reading));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readingHobbie);
        } else if (hobbie.equals("music")){
            WebElement musicHobbie = driver.findElement(By.xpath(Variaveis.music));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicHobbie);
        } else if(hobbie.equals("todos")){
            WebElement sportsHobbie = driver.findElement(By.xpath(Variaveis.sports));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsHobbie);
            WebElement readingHobbie = driver.findElement(By.xpath(Variaveis.reading));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readingHobbie);
            WebElement musicHobbie = driver.findElement(By.xpath(Variaveis.music));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicHobbie);
        }
    }

    public void uploadArquivo(){
        driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]")).sendKeys(
                System.getProperty("user.dir") + "\\teste.txt");
    }

    public void preencheEndereco(){
        WebElement campoEndereco = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        campoEndereco.sendKeys(Variaveis.enderecoFake);
        campoEndereco.sendKeys(Keys.TAB);
    }

    public void preencheEstadoCidade(){
        String state = "ncr";
        String city = "Delhi";
        WebElement campoState = driver.findElement(By.id("react-select-3-input"));
        campoState.sendKeys(state);
        campoState.sendKeys(Keys.TAB);

        WebElement campoCity = driver.findElement(By.id("react-select-4-input"));
        campoCity.sendKeys(city);
        campoCity.sendKeys(Keys.TAB);
    }

}
