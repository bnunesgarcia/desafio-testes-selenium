#language: pt
Funcionalidade: Acessar a aplicação demoqa para submeter um formulário
    Eu como analista de testes
    Quero acessar a aplicação demoqa
    Para submeter um formulãrio no submenu forms

  Esquema do Cenário: Acessar formulario para preenchimento
      Dado que eu acesse a aplicacao demoqa
      E o menu <menu> esta disponivel
      Quando eu clico no menu <menu>
      E clico no submenu <submenu>
      E o formulario para preenchimento deve ser disponibilizado

      Exemplos:
      | menu  | submenu       |
      | forms | practice form |

  Esquema do Cenario: Submeter formulario
      Dado que eu acesse a aplicacao demoqa
      E o menu <menu> esta disponivel
      Quando eu clico no menu <menu>
      E clico no submenu <submenu>
      E preencho o Primeiro Nome
      E preencho o Sobrenome
      E preencho o e-mail
      E seleciono o checkbox Gender do tipo <gender>
      E digito o numero de telefone
      E preencho a data de nascimento
      E seleciono um cargo na lista de cargos
      E seleciona o checkbox hobbie do tipo <hobbie>
      E realizo o upload de um arquivo txt
      E preencho o campo Endereco
      E preencho State and City
      E eu clico em Submit para concluir o preenchimento do formulario
      E um popup e disponibilizado com as informacoes de preenchimento
      E eu fecho o popup

      Exemplos:
          | menu  | submenu       | gender    | hobbie  |
          | forms | practice form | masculino | sports  |
          | forms | practice form | feminino  | reading |
          | forms | practice form | outros    | music   |
          | forms | practice form | masculino | todos   |
          | forms | practice form | feminino  | todos   |
          | forms | practice form | outros    | todos   |
