![Logo](images/logo1.png)
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/>
# Teste automatizado de acessibilidade Selenium Java, Cucumber, AXE.

Este é um modelo criado como exemplo para realizar a automação de testes de acessibilidade utilizando os frameworks Selenium+Cucumber+Java com o Axe.
O exemplo foi executado em uma URL criada para treinar automação de teste WEB.

___

O **Selenium** é um conjunto de ferramentas para automatizar navegadores da Web.
O Selenium WebDriver conduz um navegador nativamente, como um usuário real faria, localmente ou em máquinas remotas.

**Axe** é um mecanismo de teste de acessibilidade para sites e outras interfaces de usuário baseadas em HTML. É rápido, seguro, leve, e foi construído para se integrar perfeitamente a qualquer ambiente de teste existente para que você possa automatizar testes de acessibilidade ao lado de seus testes funcionais regulares.

O **"axe-core Selenium (Java)"** é uma ferramenta para usar o Axe para testes utilizando Junit e Selenium.
A integração do Selênio permite o teste de páginas e sites completos.
Para maiores detalhes, acesse o link: https://github.com/dequelabs/axe-core-maven-html

#
# Getting Started

Antes de começar, verifique se você tem instalado em sua maquina o **Maven** o navegador **Google Chrome** e o **Java**(V >=11).
```console
mvn -version
java -version
```

___
**Instalação e 1º execução**
Instale as dependências e rode o primeiro teste executando o comando abaixo na raiz do projeto:
```console
mvn  install
```
Após a execução dos testes, um relatório em HTML é gerado na pasta `target\generated-report`. Dentro desta pasta abra o arquivo `index.html` para visualizar o relatório no seu browser e acessar todos os detalhes da execução. Ele deve ser exibido conforme abaixo:

![report](imgs/)


O relatório utilizado foi o [Cluecumber Report Plugin](https://github.com/trivago/cluecumber-report-plugin), para mais configurações acesse a documentação no [link](https://github.com/trivago/cluecumber-report-plugin).

___

**Execução dos Testes**

Apos a instalação das dependências e a execução do primeiro teste, voce pode executar somente os teste utilizando o comando abaixo na raiz do projeto:

```console
mvn test
```

Após essa execução, o relatório de teste não será atualizado automaticamente. Para atualizar o relatório execute o comando abaixo

```console
mvn cluecumber-report:reporting
```
___


# Análise de impacto e conformidade
No relatório é possivel verificar os alertas de acessibilidade.
Segue abaixo um exemplo de como o alerta é exibido:

```txt
{
    "description": "Ensures (meta name=\"viewport\") does not disable text scaling and zooming",
    "help": "Zooming and scaling must not be disabled",
    "helpUrl": "https://dequeuniversity.com/rules/axe/4.0/meta-viewport?application=webdriverjs",
    "id": "meta-viewport",
    "impact": "critical",
    "nodes": [
      {
        "all": [],
        "any": [
          {
            "data": "user-scalable=no",
            "id": "meta-viewport",
            "impact": "critical",
            "message": "user-scalable=no on (meta) tag disables zooming on mobile devices",
            "relatedNodes": []
          }
        ],
        "failureSummary": "Fix any of the following:\n  user-scalable=no on (meta) tag disables zooming on mobile devices",
        "html": "(meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\")",
        "impact": "critical",
        "none": [],
        "target": [
          "meta[name=\"viewport\"]"
        ]
      }
    ],
    "tags": [
      "cat.sensory-and-visual-cues",
      "best-practice"
    ]
  },
```
Neste exemplo temos um impacto crítico sendo validado as boas práticas.

Ao abrir o link indicado no **"helpUrl"**, nele é exibido toda a descrição do impacto e até mesmo a forma de correção.
Também é exibido um resumo com as principais informações.

![resumoImpacto](images/impacto.png)



----
Segue abaixo o link que contém a lista de todas as regras de acessibilidade que podem ser aplicadas nos testes
- https://github.com/dequelabs/axe-core/blob/master/doc/rule-descriptions.md



# Referencias



- https://mvnrepository.com/artifact/com.deque.html.axe-core/selenium/4.1.1
- https://www.deque.com/blog/axe-core-packages-migrating/
- https://github.com/dequelabs/axe-selenium-java
