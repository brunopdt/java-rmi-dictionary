import java.io.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServant extends java.rmi.server.UnicastRemoteObject implements Dictionary, Serializable {

	private static final long serialVersionUID = 1L;
	// Declaração do dicionário que os métodos da classe afetarão
	private Map<String, String> dictionary;

	private final String SUCCESS_RESPONSE = "Operação realizada com sucesso!";
	private final String KEY_NOT_FOUND_ERROR = "Erro: chave não encontrada";
	private final String DUPLICATE_KEY_ERROR = "Erro: chave já existe";

	// Ao instanciar o objeto remoto, é iniciado um novo hashmap
	public DictionaryServant() throws java.rmi.RemoteException {
		super();
		dictionary = new HashMap<>();
		loadState(); // Carregar estado inicial do dicionário
	}

	// Método que adiciona palavras ao dicionário
	public String add(String key, String value) throws RemoteException {
		if (dictionary.containsKey(key)) {
			return DUPLICATE_KEY_ERROR;
		} else {
			dictionary.put(key, value);
			saveState(); // Salvar estado após adicionar uma palavra
			return SUCCESS_RESPONSE;
		}
	}

	// Método que remove palavras no dicionário
	public String remove(String key) throws RemoteException {
		if (dictionary.containsKey(key)) {
			dictionary.remove(key);
			saveState(); // Salvar estado após remover uma palavra
			return SUCCESS_RESPONSE;
		} else {
			return KEY_NOT_FOUND_ERROR;
		}
	}

	// Método que busca palavras no dicionário
	public String lookup(String key) throws RemoteException {
		String value = dictionary.get(key);
		if (value != null) {
			return value;
		} else {
			return KEY_NOT_FOUND_ERROR;
		}
	}

	private void saveState() {
		try {
			// Serializar o objeto dictionary e salvá-lo em um arquivo
			FileOutputStream fileOut = new FileOutputStream("dictionary.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dictionary);
			out.close();
			fileOut.close();
			System.out.println("Estado do dicionário salvo com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao salvar o estado do dicionário: " + e.getMessage());
		}
	}

	// Implementação para carregar o estado do dicionário a partir de um arquivo
	@SuppressWarnings("unchecked")
	private void loadState() {
		try {
			// Desserializar o objeto dictionary do arquivo
			FileInputStream fileIn = new FileInputStream("dictionary.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			dictionary = (Map<String, String>) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Estado do dicionário carregado com sucesso.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro ao carregar o estado do dicionário: " + e.getMessage());
		}
	}
}
