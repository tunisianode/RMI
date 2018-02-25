package UDP.Unicast;

import UDP.UDPSocket;

public class Server
{
    public static void main(String[] args){
        int counter =0;

        try(UDPSocket socket = new UDPSocket(1250))
        {
            System.out.println("Server wartet");

            while(true){
                String  request = socket.receive(20);
                if(request.equals("increment")){
                    counter ++;
                }else {
                    counter = 0;
                }
                socket.reply(String.valueOf(counter));
            }

        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
