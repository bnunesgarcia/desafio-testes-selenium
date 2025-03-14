# deafio-automacao
Desafio de testes automatizados frontend

Aqui está um exemplo de README que você pode usar como base para o seu projeto de testes automatizados:

**Projeto de Testes Automatizados com BDD e Selenium**

**Descrição**

Este projeto utiliza o framework de testes BDD (Behavior-Driven Development) com Gherkin para criar planos de testes automatizados para uma aplicação web. Os testes são escritos em Java e utilizam o Selenium WebDriver para interagir com a aplicação.

**Estrutura do Projeto**

* **PageObjects**: contém as classes que representam as páginas da aplicação e os métodos para interagir com elas.
* **Utils**: contém as classes de utilidade para auxiliar nos testes.
* **Testes**: contém as classes de teste que utilizam o framework de testes BDD com Gherkin.

**Tecnologias Utilizadas**

* **Java**: linguagem de programação utilizada para escrever os testes.
* **Selenium WebDriver**: framework de automação de navegador utilizado para interagir com a aplicação.
* **Gherkin**: framework de testes BDD utilizado para criar planos de testes.
* **Maven**: ferramenta de gerenciamento de dependências e build utilizada para compilar e executar os testes.

**Pipeline de Integração Contínua**

O pipeline de integração contínua é configurado para executar os seguintes passos:

1. **Build e Instalação**: compila e instala o projeto utilizando o Maven.
2. **Execução de Testes**: executa os testes utilizando o Maven e o framework de testes BDD com Gherkin.
3. **Publicação de Resultados**: publica os resultados dos testes no Azure DevOps.

**Configuração do Pipeline**

O pipeline é configurado para ser executado automaticamente a cada push no branch master. A configuração do pipeline está no arquivo `azure-pipelines.yml`.

**Como Executar os Testes**

Para executar os testes localmente, é necessário ter o Maven e o Java instalados no ambiente. Execute o comando `mvn test` para executar os testes.

**Como Contribuir**

Para contribuir com o projeto, é necessário ter conhecimento em Java, Selenium WebDriver e Gherkin. Os testes devem ser escritos seguindo as boas práticas de programação e os padrões de teste BDD. Os pull requests devem ser enviados para o branch master.
