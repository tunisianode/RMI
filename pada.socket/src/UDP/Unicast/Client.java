package UDP.Unicast;

import UDP.UDPSocket;

import java.net.*;
public class Client
{


    public static void main(String[] args){
        int timeout=10000;
        int counter =0;
        String reply="";
        try(UDPSocket socket = new UDPSocket())
        {
            socket.setTimeout(timeout);
            socket.send("reset",InetAddress.getLocalHost(),1250);

            try
            {
                socket.receive(20);
                System.out.println(reply);
            }catch(Exception es){
                System.out.println(es.getStackTrace());
            }

            for (int i =0;i<10;i++){
                socket.send("increment",InetAddress.getLocalHost(),1250);
                try
                {
                    reply=socket.receive(20);
                }catch(Exception e){
                    System.out.println(e.getStackTrace());

                }
                System.out.println("antwort von server");

                System.out.println(reply);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
