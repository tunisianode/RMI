package UDP.Multicast;

import UDP.Multicast.UDPMulticastSocket;

public class ServerMulticast
{

    public static void main (String[] args){

        try(UDPMulticastSocket socket = new UDPMulticastSocket(1250))
        {
            System.out.println("multicast socket created");
            socket.join("226.1.2.3");
            System.out.println("join multicastgroup");


            while(true){
                String request = socket.receive(200);
                System.out.println("recived from :" + socket.getsendAdress() + ":"+ socket.getSenderPort()+":"+request);


                socket.reply(request);

                if (request.equals("exit"))break;
            }

            socket.leave("226.1.2.3");
            System.out.println("left multicast group");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
