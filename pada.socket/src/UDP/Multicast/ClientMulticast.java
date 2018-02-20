package UDP.Multicast;

import UDP.UDPSocket;

import java.net.InetAddress;

public class ClientMulticast
{

    public static void main (String[] args){

        try(UDPSocket socket = new UDPSocket()){
            InetAddress address = InetAddress.getLocalHost();
            for (int i = 0; i < 10 ; i++)
            {
                socket.send("hallo welt",address,1250);

                try
                {
                    while(true){
                        String reply = socket.receive(200);
                        System.out.println(reply);
                    }
                }catch(Exception e){

                }
            }

        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }

        System.out.println("socket closed");
    }
}
