package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.pages.PreencheFormularioPages;
import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import org.openqa.selenium.By;
import io.cucumber.java.pt.E;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


    public class PreencherFormulario extends Utils {

        PreencheFormularioPages preencheFormulario = new PreencheFormularioPages();

        @E("preencho o Primeiro Nome")
        public void preenchoOPrimeiroNomeComONomeCriado() {
            preencheFormulario.preencheFirstName();
        }

        @E("preencho o Sobrenome")
        public void preenchoOSobrenomeComOSobrenomeCriado() {
            preencheFormulario.preencheLastName();
        }

        @E("preencho o e-mail")
        public void preenchoOEmailComOEmailCriado() {
            preencheFormulario.preencheEmail();
        }

        @E("seleciono o checkbox Gender do tipo {}")
        public void selecionoOCheckboxGenderDoTipo(String gender) {
            preencheFormulario.selecionaGender(gender);
        }

        @E("digito o numero de telefone")
        public void digitoONumeroDeTelefoneDe10DigitosQueFoiCriado() {
            preencheFormulario.preencheTelefone();
        }

        @E("preencho a data de nascimento")
        public void selecionoADateDeNascimentoNoCalendario() {
            preencheFormulario.selecionaDataNascimento();
        }

        @E("seleciono um cargo na lista de cargos")
        public void selecionoUmCargoNaListaDeCargos() {
            preencheFormulario.selecionaSubject();
        }

        @E("seleciona o checkbox hobbie do tipo {}")
        public void selecionaOCheckboxHobbieDoTipo(String hobbie) {
            preencheFormulario.selecionaHobbie(hobbie);
        }

        @E("realizo o upload de um arquivo txt")
        public void realizoOUploadDeUmArquivoTxtQueConstaNaRaizDoProjeto() {
            preencheFormulario.uploadArquivo();
        }

        @E("preencho o campo Endereco")
        public void preenchoOCampoEnderecoComOEnderecoCriado() {
            preencheFormulario.preencheEndereco();
        }

        @E("preencho State and City")
        public void preencherEstadoECidade() {
            preencheFormulario.preencheEstadoCidade();
        }

        @E("eu clico em Submit para concluir o preenchimento do formulario")
        public void submeterFormulario(){
            WebElement botaoSubmit = driver.findElement(By.id("submit"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoSubmit);
            esperarElementoEstarVisivel(By.xpath("//div[4]/div/div/div[1]"), 5);
            esperarElementoEstarVisivel(By.xpath("//div[4]/div/div/div[2]"), 5);
            esperarElementoEstarVisivel(By.xpath("//div[4]/div/div/div[3]"), 5);
        }

        @E("um popup e disponibilizado com as informacoes de preenchimento")
        public void validarInformacoesPreenchidas(){
            esperarDadoEstarVisivel(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"), Variaveis.nomeFake + " " + Variaveis.sobrenomeFake, 3);
            esperarDadoEstarVisivel(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]"), Variaveis.emailFake, 3);
            esperarDadoEstarVisivel(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]"), Variaveis.numeroFake, 3);
            esperarDadoEstarVisivel(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]"), "teste.txt", 3);
            esperarDadoEstarVisivel(By.xpath("//div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]"), Variaveis.enderecoFake, 3);
        }

        @E("eu fecho o popup")
        public void euFechoOPopupClicandoForaDele() {
            driver.findElement(By.xpath("//body")).click();
        }
    }
