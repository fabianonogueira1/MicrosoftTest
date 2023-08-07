# MicrosoftTest
Nesse repositório, você encontrará os seguintes arquivos e pastas:

pom.xml: Arquivo de configuração do Maven com as dependências necessárias.
src/test/java/microsoftTest: Pasta que contém os arquivos de teste Java.
src/test/resources/config.json: Arquivo JSON com a conexão SQL fictícia.
src/main/java/microsoftTest/pages: Pasta que contém as classes de página do POM.
src/main/java/microsoftTest/pages/BasePage.java: Classe abstrata que representa a página base.
src/main/java/microsoftTest/factories/PageFactory.java: Factory para criar páginas do POM.

Cenarios de test:
1 Acesse https://www.microsoft.com/en-us/
2 Valide se todos os itens de menu estão presentes (Microsoft 365 - Windows - Surface - Xbox – Ofertas – Small Business - Suporte)
3 Vá para o Windows
4 Uma vez na página do Windows, clique no menu Sobre o Windows
5 Imprima todos os elementos no menu suspenso
6 Vá para Pesquisar ao lado do link Entrar
7 Procure por Visual Studio
8 Imprima o preço do elemento selecionado
9 Armazene o preço
10 Clique em Get a Visual Studio Enterprise Subscription
11 Uma vez na página de detalhes, valide se ambos os preços NÃO são iguais
12 Clique em Adicionar ao carrinho
13 Verifique se todos os 3 valores de preço (Individual, Itens, Total) são os mesmos
14 No menu suspenso # de itens, selecione 20 e confirme se o valor total é Preço unitário * 20


Critérios de Aceitação
• Linguagens aceitas:  Java
• POM e Fábrica de Páginas
• Use no caso de Java use TestNG ou Cucumber
• Use Asserções
• Ter pelo menos uma interface ou classe abstrata
