Feature: Validar itens do menu no site da Microsoft

  Scenario: Acessar https://www.microsoft.com/en-us/ e validar os itens de menu
  @Given que acesso a página principal da Microsoft
  @Then todos os seguintes itens do menu estão presentes:
  | Microsoft 365   |
  | Windows         |
  | Surface         |
  | Xbox            |
  | Deals           |
  | Small Business  |
  | Support         |

  Scenario: Vá para o Windows e clique no menu Sobre o Windows
  @Given que acesso a página principal da Microsoft
  @When clico no botão Windows no menu
  @Then verifico que o menu Sobre o Windows está presente
  @And imprimo todos os elementos no menu suspenso do Sobre o Windows

  Scenario: Pesquisar e verificar o preço do Visual Studio
  @Given que acesso a página principal da Microsoft
  @When clico no link Pesquisar ao lado do link Entrar
  @And pesquiso por "Visual Studio"
  @Then verifico o preço do elemento selecionado e armazeno o preço

  Scenario: Acessar página de detalhes da Visual Studio Enterprise Subscription
  @Given que acesso a página principal da Microsoft
  @When clico em "Get a Visual Studio Enterprise Subscription"
  @Then valido que os preços individuais não são iguais
  @And clico em "Adicionar ao carrinho"
  @And verifico se os 3 valores de preço (Individual, Itens, Total) são os mesmos

  Scenario: Verificar o valor total após selecionar 20 itens
  @Given que acesso a página de detalhes da Visual Studio Enterprise Subscription
  @When seleciono 20 itens no menu suspenso # de itens
  @Then verifico se o valor total é Preço unitário * 20
