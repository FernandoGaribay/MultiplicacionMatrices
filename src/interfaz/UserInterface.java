package interfaz;


import componentes.PreviewPanel;
import componentes.panelMatriz;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInterface extends Remote{
    String getName() throws RemoteException;
    void recibirSeedA(long seedA) throws RemoteException;
    void recibirSeedB(long seedB) throws RemoteException;
    void getMatrizA() throws RemoteException;
    void getMatrizB() throws RemoteException;
    void setPanelsListeners(PreviewPanel previewPanel, panelMatriz panelA, panelMatriz panelB) throws RemoteException;
    void recibirMatrices(int inicio, int fin, int filas, int columnas) throws RemoteException;
}
