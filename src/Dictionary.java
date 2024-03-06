// Interface dos métodos implementados pela classe do dicionário
public interface Dictionary extends java.rmi.Remote {

	public String add(String key, String value) throws java.rmi.RemoteException;

	public String remove(String key) throws java.rmi.RemoteException;

	public String lookup(String key) throws java.rmi.RemoteException;
}
