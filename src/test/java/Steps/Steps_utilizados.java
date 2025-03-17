package Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Elementos.Elementos_de_Tela;
import Metodos.Metodos_deuso;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;

public class Steps_utilizados {
	
	Metodos_deuso metodo = new Metodos_deuso();
	Elementos_de_Tela elemento = new Elementos_de_Tela();


	@Dado("que acesso o site {string}")
	public void que_acesso_o_site(String string) {
	metodo.abrirNavegador(string);
	}

	@Quando("eu insiro o usuário {string} e a senha {string} válidos")
	public void eu_insiro_o_usuário_e_a_senha_válidos(String string, String string2) {
	    metodo.preencher(elemento.getCampoNome(), string );
	    metodo.preencher(elemento.getCampoSenha(), string2 );
	}

	@Quando("clicar em login")
	public void clicar_em_login() {
	    metodo.clicar(elemento.getBtnLogin());
	}

	

		@Então("o usuário deverá estar logado no sistema com status {string}")
		public void o_usuário_deverá_estar_logado_no_sistema_com_status(String status) throws InterruptedException {
		   metodo.pausar(3000); 

		    
		    String urlAtual = metodo.getDriver().getCurrentUrl();
		    boolean loginEfetuado = urlAtual.contains("inventory.html");

		    
		    String esperado = status.equals("sucesso") ? "sucesso" : "falha";
		    String obtido = loginEfetuado ? "sucesso" : "falha";

		    
		    System.out.println("Esperado: " + esperado);
		    System.out.println("Obtido: " + obtido);

		    
		    Assert.assertEquals("O status do login não é o esperado!", esperado, obtido);
		    metodo.fecharNavegador();
		}
	

@Quando("eu insiro o usuário {string} e a senha {string} inválidos")
public void eu_insiro_o_usuário_e_a_senha_inválidos(String string, String string2) {
    metodo.preencher(elemento.getCampoNome(), string);
    metodo.preencher(elemento.getCampoSenha(), string2);
}

@Então("o sistema deve exibir a mensagem de erro {string}")
public void o_sistema_deve_exibir_a_mensagem_de_erro(String mensagemEsperada) {
    metodo.aguardarElementoVisivel(elemento.getMensagemErro());
    metodo.aguardarElementoVisivel(By.className("error-message-container")); 

    
    WebElement mensagemErro = metodo.getDriver().findElement(By.className("error-message-container"));
    String mensagemObtida = mensagemErro.getText();

    System.out.println("Mensagem Esperada: " + mensagemEsperada);
    System.out.println("Mensagem Obtida: " + mensagemObtida);

   
    Assert.assertEquals("A mensagem de erro não está correta!", mensagemEsperada, mensagemObtida);
    metodo.fecharNavegador();
}
 
}








