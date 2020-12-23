package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class TransferPage extends BasePage {

	
	public void AbaTransferencia(){
		clicarBotao(By.id("transfer_funds_tab")); 
	}
	
	public void CampoValor(String valor){
		escrever(By.id("tf_amount"), valor); 
	}
	
	public void BotaoContinue(){
		clicarBotao(By.id("btn_submit")); 
	}
	
	public void abaSummary(){
		clicarBotao(By.id("account_summary_tab")); 
	}
	
	public String MensagemTransfSucesso(){
		aguardarVisivel(By.cssSelector(".alert-success"));
		return obterTexto(By.cssSelector(".alert-success"));
	}
}
