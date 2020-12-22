package pages;

import org.openqa.selenium.By;

import core.BasePage;



public class LoginPage extends BasePage {
	
	
	public void BotaoLogar(){
		clicarBotao(By.id("signin_button")); 
	}
	
	public void setUser(String user) {
		aguardarVisiveleClicavel(By.id("user_login"));
		escrever(By.id("user_login"), user);
	}
	
	public void setSenha(String senha) {
		
		escrever(By.id("user_password"), senha);
	}
	
	public void Singin(){
		clicarBotao(By.xpath("//*[@name='submit']")); 
	}

	public void setlogar(String user, String senha) {
		BotaoLogar();
		setUser(user);
		setSenha(senha);
		Singin();
	}
	
}
