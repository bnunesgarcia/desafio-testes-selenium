#language: pt
Funcionalidade: Acessar a aplicação demoqa para manipular registros
    Eu como analista de testes
    Quero acessar a aplicação demoqa
    Para manipular registros no menu Web Tables

    Esquema do Cenário: Criar um novo registro no menu Web Tables
        Dado que eu acesse a aplicacao demoqa
        E o menu <menu> esta disponivel
        Quando eu clico no menu <menu>
        E clico no submenu <submenu>
        Entao o botao <botao> deve esta disponivel
        E eu clico no botao <botao>
        E um popup para preenchimento de novo registro aparece
        E eu preencho a informacao de Nome com <nome>
        E eu preencho a informacao de sobrenome com <sobrenome>
        E eu preencho a informacao de email com <email>
        E eu preencho a informacao de idade com <idade>
        E eu preencho a informacao de salario com <salario>
        E eu preencho a informacao de departamento com <departamento>
        E eu realizo o submit da criacao do novo registro
        E eu valido que os dados foram inseridos na tabela de registros

        Exemplos:
            | menu     | submenu    | botao | nome    | sobrenome | email                | idade | salario | departamento |
            | elements | web tables | add   | Bruno   | Garcia    | brunoteste@teste.com | 36    | 10000   | Insurance    |
            | elements | web tables | add   | Gael    | Garcia    | gaelteste@teste.com  | 20    | 8000    | Insurance    |
            | elements | web tables | add   | Benicio | Garcia    | beniteste@teste.com  | 25    | 4000    | Insurance    |
            | elements | web tables | add   | Monica  | Garcia    | moniteste@teste.com  | 36    | 6000    | Insurance    |

    Esquema do Cenário: Alterar registro criado
        Dado que eu acesse a aplicacao demoqa
        E o menu <menu> esta disponivel
        Quando eu clico no menu <menu>
        E clico no submenu <submenu>
        Entao o botao <botao> deve esta disponivel
        E eu clico no botao <botao>
        E um popup para preenchimento de novo registro aparece
        E eu preencho a informacao de Nome com <nome>
        E eu preencho a informacao de sobrenome com <sobrenome>
        E eu preencho a informacao de email com <email>
        E eu preencho a informacao de idade com <idade>
        E eu preencho a informacao de salario com <salario>
        E eu preencho a informacao de departamento com <departamento>
        E eu realizo o submit da criacao do novo registro
        E eu valido que os dados foram inseridos na tabela de registros
        E eu acesso a tela de editar dados
        E eu altero o nome para <nomeAlterado>
        E eu altero o sobrenome para <sobrenomeAlterado>
        E eu realizo o submit da alteracao do registro
        E eu valido que os dados foram alterados corretamente

        Exemplos:
            | menu     | submenu    | botao | nome    | sobrenome | email                | idade | salario | departamento | nomeAlterado | sobrenomeAlterado |
            | elements | web tables | add   | Bruno   | Garcia    | brunoteste@teste.com | 36    | 10000   | Insurance    | Gael         | Garcia            |