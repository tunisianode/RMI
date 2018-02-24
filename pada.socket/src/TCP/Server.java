package TCP;

import java.net.ServerSocket;

public class Server
{
    public static void main(String[] args)
    {
        int counter = 0;

        try(ServerSocket serverSocket = new ServerSocket(1250))
        {
            while(true){
                System.out.println("warte auf verbindung");

                try(TCPSocket tcpSocket = new TCPSocket(serverSocket.accept()))
                {
                    while(true){
                        String request = tcpSocket.reciveLine();

                        if(request != null )
                        {
                            if(request.equals("increment")){
                                counter++;
                                System.out.println("couter wurde erhöht");
                            }else if (request.equals("reset")){
                                counter=0;
                                System.out.println("couter wurde züruck gestzt");
                            }
                            String result = String.valueOf(counter);
                            tcpSocket.sendLine(request);

                        }else {
                            System.out.println("schließen der Verbindung");
                            break;
                        }
                    }
                }catch(Exception ex){

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
