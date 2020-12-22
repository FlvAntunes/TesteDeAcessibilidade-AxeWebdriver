package steps;

import static core.DriverFactory.getDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.naming.OperationNotSupportedException;

import core.Accessibility;
import core.BasePage;
import core.DriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;

public class cenarioStep extends BasePage {

	private static LoginPage login = new LoginPage();
	private static core.Accessibility teste = new Accessibility();

	public static Object body;

	@Dado("que o usuario acesse o site {string}")
	public void queOUsuarioAcesseOSite(String string) {
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		DriverFactory.getDriver().get(string);

	}

	@Dado("realize o login com o usuario {string} e senha {string}")
	public void realizeOLoginComOUsuarioESenha(String string, String string2) {
		login.setlogar(string, string2);

	}

	@Dado("verifico se padrão de acessibilidade possui todas as diretrizes")
	public void verificoSePadraoDeAcessibilidadePossuiTodasAsDiretrizes()
			throws OperationNotSupportedException, IOException {
		teste.checkAll();
	}

	@Quando("ele acessar a funcionalidade de transferencia")
	public void eleAcessarAFuncionalidadeDeTransferencia() {

	}

	@Quando("preencher o valor {string}")
	public void preencherOValor(String string) {

	}

	@Quando("confirmar a transferencia")
	public void confirmarATransferencia() {

	}

	@Entao("verifico o padrão de melhores praticas de acessibilidade")
	public void verificoOPadraoDeMelhoresPraticasDeAcessibilidade() throws OperationNotSupportedException, IOException {
		teste.checkBestPractice();

	}

	@Entao("verifico o padrão de acessibilidade wcag21aa")
	public void verificoOPadraoDeAcessibilidadeWcag21aa() throws OperationNotSupportedException, IOException {
		teste.checkWcag21aa();
	}

	@Entao("deve ser exibido a mensagem {string}")
	public void deveSerExibidoAMensagem(String string) {

	}

}
