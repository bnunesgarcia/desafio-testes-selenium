#language: pt
Funcionalidade: Validar menus na tela inicial do sistema
    Eu como analista de testes
    Quero acessar a aplicação demoqa
    Para validar através dos menus as funcionalidades existentes no sistema

    Esquema do Cenário: Validar as funcionalidades existentes no sistema
        Dado que eu acesse a aplicacao demoqa
        E o menu <menu> esta disponivel
        Quando eu clico no menu <menu>
        Entao os submenus do menu <menu> devem ser exibidos

        Exemplos:
            | menu                    |
            | elements                |
            | forms                   |
            | alerts, frame & windows |
            | widgets                 |
            | interactions            |
            | book store application  |