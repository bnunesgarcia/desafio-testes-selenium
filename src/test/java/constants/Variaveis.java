package constants;

import java.util.Arrays;
import java.util.List;

public class Variaveis {

    public static final String menuForms = "//div[2]/div/div/div[2]/div/div[2]";
    public static final String menuAlerts = "//div[2]/div/div/div[2]/div/div[3]";
    public static final String menuElements = "//div[2]/div/div/div[2]/div/div[1]";
    public static final String widgets = "//div[2]/div/div/div[2]/div/div[4]";
    public static final String menuInteractions = "//div[2]/div/div/div[2]/div/div[5]";
    public static final String menuBookStoreApplication = "//div[2]/div/div/div[2]/div/div[6]";
    public static final String subMenuPracticeForms = "//div[2]/div/div/div/div[1]/div/div/div[2]/div/ul";
    public static final String subMenuBrowserWindows = ".show > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)";
    public static final String subMenuWebElements = ".show > ul:nth-child(1) > li:nth-child(4) > span:nth-child(2)";
    public static final String subMenuSortable = ".show > ul:nth-child(1) > li:nth-child(1)";
    public static final String subMenuLogin = ".show > ul:nth-child(1) > li:nth-child(1)";
    public static final String botaoTelaNewUser = "//*[@id=\"newUser\"]";
    public static final String campoFirstName = "//*[@id=\"firstname\"]";
    public static final String campoLastName = "//*[@id=\"lastname\"]";
    public static final String campoUserName = "//*[@id=\"userName\"]";
    public static final String campoPassword = "//*[@id=\"password\"]";
    public static final String botaoRegistrar = "//*[@id=\"register\"]";
    public static final String botaoLogin = "//*[@id=\"login\"]";
    public static final String botaoLogout = "//*[@id=\"submit\"]";
    public static final String containerMensagem = "//*[@id=\"name\"]";
    public static final String containerNomeUser = "//*[@id=\"userName-value\"]";
    public static final String campoPesquisa = "//*[@id=\"searchBox\"]";
    public static final String botaoAddNovoRegistro = "//*[@id=\"addNewRecordButton\"]";
    public static final String botaoEditaRegistro = "//*[@id=\"edit-record-1\"]";
    public static final String botaoDeletaRegistro = "//*[@id=\"delete-record-1\"]";
    public static final String campoNome = "firstName";
    public static final String campoSobrenome = "lastName";
    public static final String campoEmail = "userEmail";
    public static final String campoIdade = "age";
    public static final String campoSalario = "salary";
    public static final String campoDepto = "department";
    public static final String botaoSubmitFormulario = "//*[@id=\"submit\"]";

    public static List<String> getSubmenus(String menu) {
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

    public static final String[][] REGISTROS = {
        {"Vega", "Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance"},
        {"Cantrell", "Alden", "Cantrell", "45", "alden@example.com", "12000", "Compliance"},
        {"Gentry", "Kierra", "Gentry", "29", "kierra@example.com", "2000", "Legal"}
    };
}
