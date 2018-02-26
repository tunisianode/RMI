package Counter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("args unberprufen");
        }
        try
        {
             Counter myCounter = (Counter) Naming.lookup("rmi://"+args[0]+"/Counter");

            System.out.println("set counter to 0");
            myCounter.reset();

            System.out.println("incrementing");
            int count = new Integer(args[1]).intValue();

            int result =0;

            for (int i =0;i<count;i++)
                result=myCounter.increment();

            System.out.println("counter = "+result);
        }catch( Exception e)
        {
            System.out.println(e);
        }
    }
}
