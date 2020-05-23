package control;

import view.ActiveRaceFrame;
import view.AdmLandPage;
import view.CadastroPickFrame;
import view.ClienteCadastro;
import view.ClienteLandPage;
import view.LoginView;
import view.TaxiCadastro;
import view.TaxiLandPage;
import view.TaxiSearchFrame;

public class FrameController {
	
	private static ActiveRaceFrame activeRaceFrame = new ActiveRaceFrame();
	private static AdmLandPage admLandPage = new AdmLandPage();
	private static CadastroPickFrame cadastroPickFrame = new CadastroPickFrame();
	private static ClienteCadastro clienteCadastro = new ClienteCadastro();
	private static ClienteLandPage clienteLandPage = new ClienteLandPage();
	private static LoginView loginView = new LoginView();
	private static TaxiCadastro taxiCadastro = new TaxiCadastro();
	private static TaxiLandPage taxiLandPage = new TaxiLandPage();
	private static TaxiSearchFrame taxiSearchFrame = new TaxiSearchFrame();

	public static ActiveRaceFrame getActiveRaceFrame() {
		return activeRaceFrame;
	}

	public static void setActiveRaceFrame(ActiveRaceFrame activeRaceFrame) {
		FrameController.activeRaceFrame = activeRaceFrame;
	}

	public static AdmLandPage getAdmLandPage() {
		return admLandPage;
	}

	public static void setAdmLandPage(AdmLandPage admLandPage) {
		FrameController.admLandPage = admLandPage;
	}

	public static CadastroPickFrame getCadastroPickFrame() {
		return cadastroPickFrame;
	}

	public static void setCadastroPickFrame(CadastroPickFrame cadastroPickFrame) {
		FrameController.cadastroPickFrame = cadastroPickFrame;
	}

	public static ClienteCadastro getClienteCadastro() {
		return clienteCadastro;
	}

	public static void setClienteCadastro(ClienteCadastro clienteCadastro) {
		FrameController.clienteCadastro = clienteCadastro;
	}

	public static ClienteLandPage getClienteLandPage() {
		return clienteLandPage;
	}

	public static void setClienteLandPage(ClienteLandPage clienteLandPage) {
		FrameController.clienteLandPage = clienteLandPage;
	}

	public static LoginView getLoginView() {
		return loginView;
	}

	public static void setLoginView(LoginView loginView) {
		FrameController.loginView = loginView;
	}

	public static TaxiCadastro getTaxiCadastro() {
		return taxiCadastro;
	}

	public static void setTaxiCadastro(TaxiCadastro taxiCadastro) {
		FrameController.taxiCadastro = taxiCadastro;
	}

	public static TaxiLandPage getTaxiLandPage() {
		return taxiLandPage;
	}

	public static void setTaxiLandPage(TaxiLandPage taxiLandPage) {
		FrameController.taxiLandPage = taxiLandPage;
	}

	public static TaxiSearchFrame getTaxiSearchFrame() {
		return taxiSearchFrame;
	}

	public static void setTaxiSearchFrame(TaxiSearchFrame taxiSearchFrame) {
		FrameController.taxiSearchFrame = taxiSearchFrame;
	}

}
