package interfaz;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInterface extends Remote{
    String getName() throws RemoteException;
    void recibirSeed(long seedA, long seedB) throws RemoteException;
    void recibirMatrices(int inicio, int fin, int filas, int columnas) throws RemoteException;
}
