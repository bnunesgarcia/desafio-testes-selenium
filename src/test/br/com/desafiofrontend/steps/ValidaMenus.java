package br.com.desafiofrontend.steps;

import br.com.desafiofrontend.pages.AcessaFuncionalidadesPages;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static br.com.desafiofrontend.runner.RunCucumberTest.driver;

public class ValidaMenus {

    AcessaFuncionalidadesPages validaMenu = new AcessaFuncionalidadesPages();

    @E("o menu {} esta disponivel")
    public void oMenuDeveEstarDisponivel(String menu) {
        validaMenu.validaExibicaoMenu(menu);
    }

    @Quando("eu clico no menu {}")
    public void euClicoNoMenu(String menu) {
        validaMenu.acessaMenu(menu);
    }

    @Entao("os submenus do menu {} devem ser exibidos")
    public void validarSubmenu(String menu) {
        validaMenu.validaSubMenu(menu);
    }
    @E("clico no submenu {}")
    public void euClicoNoSubmenu(String submenu) {
        validaMenu.acessaSubMenu(submenu);
    }
}
