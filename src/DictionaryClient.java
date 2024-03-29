
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class DictionaryClient {
	// Invoca método remoto de procurar o significado da palavra
	private static void lookup(Scanner sc, Dictionary dic) throws RemoteException {
		System.out.print("Digite o nome da chave que gostaria de saber o significado: ");
		String key = sc.nextLine();
		String result = dic.lookup(key);
		System.out.println(key + "\": " + result + "\n");
	}

	// Invoca método remoto de adicionar palavra
	private static void add(Scanner sc, Dictionary dic) throws RemoteException {
		System.out.print("Digite o nome da chave que gostaria de adicionar: ");
		String key = sc.nextLine();
		System.out.print("Digite o significado da palavra: \"" + key + "\": ");
		String value = sc.nextLine();
		String result = dic.add(key, value);
		System.out.println(result + "\n");
	}

	// Invoca método remoto de remover palavra do dicionário
	private static void remove(Scanner sc, Dictionary dic) throws RemoteException {
		System.out.print("Digite a chave que gostaria de remover: ");
		String key = sc.nextLine();
		String result = dic.remove(key);
		System.out.println(result + "\n");
	}

	public static void main(String[] args) {
		// Caso um endereço não seja fornecido, o servidor é buscado em localhost
		String serverAddress = "localhost";
		String serviceName = "/DictionaryServer";
		if (args.length == 1)
			serverAddress = args[0];

		int input;
		Scanner sc = new Scanner(System.in);

		try {
			// Busca instanciar um objeto remoto
			Dictionary dic = (Dictionary) Naming.lookup("rmi://" + serverAddress + serviceName);
			System.out.println("Objeto remoto \'" + serviceName + "\' encontrado no servidor.");

			// Loop de questões
			do {
				System.out.println("O que gostaria de fazer?");
				System.out.println("1 - Consultar o significado de uma palavra");
				System.out.println("2 - Adicionar nova palavra");
				System.out.println("3 - Remover palavra");
				System.out.println("9 - Sair");

				input = sc.nextInt();
				sc.nextLine();

				switch (input) {
					case 1:
						lookup(sc, dic);
						break;
					case 2:
						add(sc, dic);
						break;
					case 3:
						remove(sc, dic);
						break;
					case 9:
						System.out.println("Exiting...");
						break;
					default:
						System.out.println("Invalid option");
						break;
				}

			} while (input != 9);

		} catch (MalformedURLException e) {
			System.out.println("URL \'" + serverAddress + serviceName + "\' mal formatada.");
		} catch (RemoteException e) {
			System.out.println("Erro na invocacao remota.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Objeto remoto \'" + serviceName + "\' nao esta disponivel.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
