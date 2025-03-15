package Elementos;

import org.openqa.selenium.By;

public class Elementos_de_Tela {

    private By campoNome = By.id("user-name");
    private By campoSenha = By.xpath("//*[@id=\"password\"]");
    private By btnLogin = By.xpath("//*[@id=\"login-button\"]");
    private By mensagemErro = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    
    public By getCampoNome() {
        return campoNome;
    }

    public By getCampoSenha() {
        return campoSenha;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getMensagemErro() {
        return mensagemErro;
    }
}
