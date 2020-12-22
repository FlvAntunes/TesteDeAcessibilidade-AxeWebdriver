#language: pt

@cenarioContexto
Funcionalidade: Testar transferencia do HomeBanking usando cenario com contexto
Como um cliente
Eu quero realizar uma transferencia de valores
Para conseguir enviar dinheiro para outra conta


Contexto:
Dado que o usuario acesse o site "http://zero.webappsecurity.com/"
E realize o login com o usuario "username" e senha "password"



Cenário: 1- Verificar se a acessibilidade da pagina principal possui as melhores praticas
Entao verifico o padrão de melhores praticas de acessibilidade


Cenário: 2- Verificar se a acessibilidade da pagina principal possui todas as diretrizes
E verifico se padrão de acessibilidade possui todas as diretrizes

Cenário: 3- Verificar se a acessibilidade da pagina principal com padrão WCAG 2.1 AA
Entao verifico o padrão de acessibilidade wcag21aa


Cenário: 4- Verificar se a acessibilidade da pagina de transferencia com padrão WCAG 2.1 AA
Quando ele acessar a funcionalidade de transferencia
Entao verifico o padrão de acessibilidade wcag21aa


Cenário: 5- Verificar se a acessibilidade da pagina de confirmação de transferencia com todas as diretrizes
Quando ele acessar a funcionalidade de transferencia
E preencher o valor "333.2"
E confirmar a transferencia
Entao deve ser exibido a mensagem "You successfully submitted your transaction."
E verifico se padrão de acessibilidade possui todas as diretrizes
