package Counter;

import java.rmi.Naming;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            CounterImpl myCounter = new CounterImpl();
            Naming.rebind("Counter",myCounter);
            System.out.println("counter server ready");

        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
