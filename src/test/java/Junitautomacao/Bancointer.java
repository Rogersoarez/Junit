package Junitautomacao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bancointer {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception { 
		//comando para apontar o driver do navegador
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		//comando para indicar o meu drive instanciado
		WebDriver driver = new ChromeDriver();
		//comando para miximizar a tela
		//comando para indicar o site a ser aberto
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
		driver.manage().window().maximize();
		//driver.findElement(By.cssSelector("#my-scroll-container > div.style__ModelsSectionBackground-sc-rff0fn-1.cNeHp.d-flex.align-items-end.align-items-md-center > div > div > div > div > div > button")).click();
		driver.findElement(By.id("bt_gerar_pessoa")).click();
		String nome;
		nome = driver.findElement(By.id("nome")).getText();
		System.out.println(nome);
		//driver.quit();
		
					
	}
	
	@After
	public void tearDown() throws Exception {
		//comando para fechar página após a realização do teste
		driver.quit();
	}

	@Test
	public void test() {
		String texto;
		texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-sc-wuavw4-0.jrzRxc > div.style__Container-sc-138k8xa-0.jrVwow.d-flex.align-items-center > div > div.col-12.text-center.py-4.pt-lg-0 > h2")).getText();
		System.out.println(texto);
		assertEquals("Abra agora sua Conta Digital", texto);
	}

}
