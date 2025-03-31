#language: pt
Funcionalidade: Acessar a aplicação demoqa para manipular dados
    Eu como analista de testes
    Quero acessar a aplicação demoqa
    Para testar a manipulacao de dados na aplicacao

    Esquema do Cenario: Manipular registros no menu Web Tables
        Dado que eu acesse a aplicacao demoqa
        Quando eu clico no menu <menu>
        Entao o submenu <submenu> deve estar disponivel
        E eu acesso o <submenu>
        E acesso a tela de <operacao> registro
        E <acao> os dados do registro
        E a operacao de <tipoOper> deve ser realizada com sucesso

        Exemplos:
            | menu     | submenu    | operacao  | acao     | tipoOper  |
            | elements | web tables | adicionar | preencho | criacao   |
            | elements | web tables | editar    | altero   | alteracao |
            | elements | web tables | deletar   | excluo   | exclusao  |

    Esquema do Cenario: Pesquisar registros no menu Web Tables
        Dado que eu acesse a aplicacao demoqa
        Quando eu clico no menu <menu>
        Entao o submenu <submenu> deve estar disponivel
        E eu acesso o <submenu>
        E eu pesquiso o funcionario <registro>
        E a pesquisa deve ser realizada com sucesso para o registro <registro>

        Exemplos:
            | menu     | submenu    | registro |
            | elements | web tables | Vega     |
            | elements | web tables | Cantrell |
            | elements | web tables | Gentry   |

    
    Esquema do Cenario: Pesquisar registros invalidos
        Dado que eu acesse a aplicacao demoqa
        Quando eu clico no menu <menu>
        Entao o submenu <submenu> deve estar disponivel
        E eu acesso o <submenu>
        E eu pesquiso o funcionario <registro>
        E a pesquisa nao deve retornar dados

        Exemplos:
            | menu     | submenu    | registro |
            | elements | web tables | teste    |

            