package br.com.desafiofrontend.pages;

import br.com.desafiofrontend.support.Utils;
import constants.Variaveis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AcessaFuncionalidadesPages extends Utils {

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
        if (menu.equals("elements")) {
            List<String> submenus = Arrays.asList("Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties" );
            for (String submenu : submenus) {
                driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
                System.out.println("Submenu " + submenu + " OK!");
            }
        } else if (menu.equals("forms")) {
            String submenu = "Practice Form";
            driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
            System.out.println("Submenu " + submenu + " OK!");
        } else if (menu.equals("alerts, frame & windows")) {
            List<String> submenus = Arrays.asList("Browser Windows", "Alerts", "Frames", "Nested Frames", "Modal Dialogs");
            for (String submenu : submenus) {
                driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
                System.out.println("Submenu " + submenu + " OK!");
            }
        } else if (menu.equals("widgets")) {
            List<String> submenus = Arrays.asList("Accordian", "Auto Complete", "Date Picker", "Slider", "Progress Bar", "Tabs", "Tool Tips", "Menu", "Select Menu");
            for (String submenu : submenus) {
                driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
                System.out.println("Submenu " + submenu + " OK!");
            }
        } else if (menu.equals("interactions")) {
            List<String> submenus = Arrays.asList("Sortable", "Selectable", "Resizable", "Droppable", "Dragabble");
            for (String submenu : submenus) {
                driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
                System.out.println("Submenu " + submenu + " OK!");
            }
        } else if (menu.equals("book store application")) {
            List<String> submenus = Arrays.asList("Login", "Book Store", "Profile", "Book Store API");
            for (String submenu : submenus) {
                driver.findElement(By.xpath("//span[@class='text' and text()='" + submenu.substring(0, 1).toUpperCase() + submenu.substring(1) + "']")).isDisplayed();
                System.out.println("Submenu " + submenu + " OK!");
            }
        }
    }

    public void acessaSubMenu(String submenu) {
        if (submenu.equals("practice form")) {
            driver.findElement(By.xpath(Variaveis.subMenuPracticeForms)).click();
        } else if (submenu.equals("browser windows")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement browserWindowElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Variaveis.subMenuBrowserWindows)));
            browserWindowElement.click();
        } else if (submenu.equals("web tables")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement webTablesElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Variaveis.subMenuWebElements)));
            webTablesElement.click();
        } else if (submenu.equals("sortable")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement sortableElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Variaveis.subMenuSortable)));
            sortableElement.click();
        }
    }

    public void validaSubmenusDosMenus() {

    }
}