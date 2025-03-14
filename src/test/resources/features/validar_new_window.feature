#language: pt
Funcionalidade: Acessar a aplicação demoqa para validar abertura de nova tela do navegador
    Eu como analista de testes
    Quero acessar a aplicação demoqa
    Para validar mensagem em nova tela do navegador

    Esquema do Cenário: Validar mensagem na nova tela do navegador
        Dado que eu acesse a aplicacao demoqa
        E o menu <menu> esta disponivel
        Quando eu clico no menu <menu>
        E clico no submenu <submenu>
        Entao o botao <botao> deve esta disponivel
        E eu clico no botao <botao>
        E uma nova tela de navegador abre
        E eu valido a mensagem da tela

        Exemplos:
            | menu                    | submenu         | botao      |
            | alerts, frame & windows | browser windows | new window |