import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServant extends java.rmi.server.UnicastRemoteObject implements Dictionary {

	private static final long serialVersionUID = 1L;
	private Map<String, String> dictionary;

	private final String SUCCESS_RESPONSE = "Operação realizada com sucesso!";
	private final String KEY_NOT_FOUND_ERROR = "Erro: chave não encontrada";
	private final String DUPLICATE_KEY_ERROR = "Erro: chave já existe";

	public DictionaryServant() throws java.rmi.RemoteException {
		super();
		dictionary = new HashMap<>();
	}

	public String add(String key, String value) throws RemoteException {
		if (dictionary.containsKey(key)) {
			return DUPLICATE_KEY_ERROR;
		} else {
			dictionary.put(key, value);
			return SUCCESS_RESPONSE;
		}
	}

	public String remove(String key) throws RemoteException {
		if (dictionary.containsKey(key)) {
			dictionary.remove(key);
			return SUCCESS_RESPONSE;
		} else {
			return KEY_NOT_FOUND_ERROR;
		}
	}

	public String lookup(String key) throws RemoteException {
		String value = dictionary.get(key);
		if (value != null) {
			return value;
		} else {
			return KEY_NOT_FOUND_ERROR;
		}
	}

}
