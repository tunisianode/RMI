package Counter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterImpl extends UnicastRemoteObject implements Counter
{
    private int counter;

    protected CounterImpl() throws RemoteException
    {
        super();
        counter = 0;
    }

    @Override
    public synchronized int reset() throws RemoteException
    {
        counter = 0;
        return counter;
    }

    @Override
    public synchronized int increment() throws RemoteException
    {
        counter++;
        return counter;
    }
}
