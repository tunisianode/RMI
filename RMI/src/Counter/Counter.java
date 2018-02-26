package Counter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote
{
    int reset() throws RemoteException;
    int increment() throws RemoteException;
}
