package br.com.desafiofrontend.pages;

import br.com.desafiofrontend.support.Utils;
import org.openqa.selenium.By;

public class CriarMultiplosRegistrosPages extends Utils {

    public void preencherCampoNome(String nome){
        driver.findElement(By.id("firstName")).sendKeys(nome);
    }

    public void preencherCampoSobrenome(String sobrenome){
        driver.findElement(By.id("lastName")).sendKeys(sobrenome);
    }

    public void preencherCampoEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void preencherCampoIdade(String idade) {
        driver.findElement(By.id("age")).sendKeys(idade);
    }

    public void preencherCampoSalario(String salario) {
        driver.findElement(By.id("salary")).sendKeys(salario);
    }

    public void preencherCampoDepartamento(String departamento) {
        driver.findElement(By.id("department")).sendKeys(departamento);
    }

}
