import java.rmi.Naming;

public class DictionaryServer {

	public DictionaryServer() {
		try {
			Dictionary c = new DictionaryServant();
			Naming.rebind("rmi://localhost/CalculadoraService", c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		new DictionaryServer();
		System.out.println("Servidor Calculadora em execucao.");
	}
}
