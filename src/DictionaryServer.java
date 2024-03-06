import java.rmi.Naming;

public class DictionaryServer {

	public DictionaryServer(String serverAddress) {
		try {
			Dictionary c = new DictionaryServant();
			Naming.rebind(serverAddress, c);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		// Caso um endereço não seja fornecido, o servidor é iniciado em localhost
		String serverAddress = "localhost";
		if (args.length == 1)
			serverAddress = args[0];

		// Instancia o servidor e o dicionário remoto
		new DictionaryServer("rmi://" + serverAddress + "/DictionaryServer");
		System.out
				.println("Servidor do dicionario em execucao no endereco " + "rmi://" + serverAddress + "/DictionaryServer");
	}
}
