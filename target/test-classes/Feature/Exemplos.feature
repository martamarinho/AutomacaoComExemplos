#language: pt
@testespositivos
Funcionalidade: Criar Cadastro

  Esquema do Cenário: Criar cadastro com sucesso
    Dado que acesso o site "https://www.saucedemo.com/"
    Quando eu insiro o usuário "<Username>" e a senha "<Password>" válidos
    E clicar em login
    Então o usuário deverá estar logado no sistema com status "<status>"

  Exemplos:
    | Username       | Password     | status  |
    | standard_user  | secret_sauce | sucesso |
    |performance_glitch_user | secret_sauce | sucesso |
    | visual_user | secret_sauce | sucesso |
   
   @testesnegativos 
  Esquema do Cenário: Tentativa de login com credenciais inválidas
    Dado que acesso o site "https://www.saucedemo.com/"
    Quando eu insiro o usuário "<Username>" e a senha "<Password>" inválidos
    E clicar em login
    Então o sistema deve exibir a mensagem de erro "<MensagemErro>"

  Exemplos:
    | Username       | Password     | MensagemErro                                                  |
    | locked_out_user| secret_sauce | Epic sadface: Sorry, this user has been locked out.           |
    | problem_user   | erro_senha   | Epic sadface: Username and password do not match any user in this service |
    | usuario_erro   | secret_sauce | Epic sadface: Username and password do not match any user in this service |