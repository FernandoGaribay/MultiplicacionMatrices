package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JList;

public interface ServerInterface extends Remote {

    void connectUser(UserInterface usuario) throws RemoteException;
    
    void disconnectUser(UserInterface usuario) throws RemoteException;

    List<UserInterface> getConnectedUsers() throws RemoteException;

    void mandarMatrices(int inicio, int fin, int filas, int columnas, UserInterface user) throws RemoteException;

    void broadcastSeedA(long seedA) throws RemoteException;

    void broadcastSeedB(long seedB) throws RemoteException;

    void recibirMatrizParcial(int[][] matrizParcial, int inicio, int fin) throws RemoteException;

    int[][] getMatrizA(int filas, int columnas) throws RemoteException;

    int[][] getMatrizB(int filas, int columnas) throws RemoteException;

    int[][] obtenerMatrizResultante() throws RemoteException;

    int[][] getResul() throws RemoteException;
    
    void setListUsers(JList listUsers) throws RemoteException;
    
    void resetResul() throws RemoteException;

}
