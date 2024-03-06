import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServant extends java.rmi.server.UnicastRemoteObject implements Dictionary {

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
	}

	// Método que adiciona palavras ao dicionário
	public String add(String key, String value) throws RemoteException {
		if (dictionary.containsKey(key)) {
			return DUPLICATE_KEY_ERROR;
		} else {
			dictionary.put(key, value);
			return SUCCESS_RESPONSE;
		}
	}

	// Método que remove palavras no dicionário
	public String remove(String key) throws RemoteException {
		if (dictionary.containsKey(key)) {
			dictionary.remove(key);
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

}
