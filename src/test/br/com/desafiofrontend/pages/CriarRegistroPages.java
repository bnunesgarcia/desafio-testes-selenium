package br.com.desafiofrontend.pages;

import br.com.desafiofrontend.support.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

public class CriarRegistroPages extends Utils {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private String salario;
    private String departamento;

    public void validaModal(){
        driver.findElement(By.xpath("//div[4]/div/div")).isDisplayed();
    }

    public void preencheNome(String nome){
        this.nome = nome;
        driver.findElement(By.id("firstName")).sendKeys(nome);
    }

    public void preencheSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
        driver.findElement(By.id("lastName")).sendKeys(sobrenome);
    }

    public void preencheEmail(String email){
        this.email = email;
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void preencheIdade(String idade){
        this.idade = idade;
        driver.findElement(By.id("age")).sendKeys(idade);
    }

    public void preencheSalario(String salario){
        this.salario = salario;
        driver.findElement(By.id("salary")).sendKeys(salario);
    }

    public void preencheDepartamento(String departamento){
        driver.findElement(By.id("department")).sendKeys(departamento);
    }

    public void validaRegistrosNaTabela(){
        String nomeRegistrado = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]")).getText();
        String sobrenomeRegistrado = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]")).getText();
        String idadeRegistrada = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]")).getText();
        String emailRegistrado = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]")).getText();;
        String salarioRegistrado = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]")).getText();;

        Assert.assertEquals(nomeRegistrado, this.nome);
        Assert.assertEquals(sobrenomeRegistrado, this.sobrenome);
        Assert.assertEquals(idadeRegistrada, this.idade);
        Assert.assertEquals(emailRegistrado, this.email);
        Assert.assertEquals(salarioRegistrado, this.salario);
    }

}
