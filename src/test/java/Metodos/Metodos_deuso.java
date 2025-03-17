package Metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Metodos_deuso {
	private WebDriver driver; // Mantemos o driver como atributo da classe

    public Metodos_deuso() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver(); // Agora inicializamos o driver corretamente
    }

    public void abrirNavegador(String url) {
        driver.get(url); // Usa o driver da classe corretamente
        driver.manage().window().maximize();
    }

    public void clicar(By elemento) {
        driver.findElement(elemento).click();
    }

    public void pausar(int tempo) throws InterruptedException {
        Thread.sleep(tempo);
    }

    public void preencher(By elemento, String texto) {
        driver.findElement(elemento).sendKeys(texto);
    }

    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void validarTexto(By elemento, String textoEsperado) {
        String texto = driver.findElement(elemento).getText();
        System.out.println(texto);
        assertEquals(textoEsperado, texto);
    }

    public void tirarPrint(String nome) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./src/evidencias/" + nome + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    public void scroll(By elemento) {
        WebElement element = driver.findElement(elemento);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebDriver getDriver() {
        return this.driver; // Método para retornar o driver, útil para Steps
    }

    public void quit() {
        if (driver != null) {
            driver.quit(); // Fechar o navegador
        }
    }
    public String obterTexto(Object object) {
        return ((WebElement) driver.findElements((By) object)).getText();
    }

	public void aguardarElementoVisivel(By mensagemErro) {
		// TODO Auto-generated method stub
		
	}

}
