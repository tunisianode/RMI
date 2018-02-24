package TCP;

public class Client
{
    public static void main(String[] args)
    {
        System.out.println("aufbau der Verbindung");
        try(TCPSocket tcpSocket = new TCPSocket("192.168.1.166",1250))
        {
            // set counter to zero
            System.out.println("Zähler zurücksetzen");
            tcpSocket.sendLine("reset");
            String reply = tcpSocket.reciveLine();

            System.out.println("Zähler erhöhen");


            // perform increment "count" number of times
            for(int i = 0; i < 20; i++)
            {
                tcpSocket.sendLine("increment");
                reply = tcpSocket.reciveLine();
            }
            System.out.println("letzter Zählerstand"+ reply);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("TCP-Verbindung wurde geschlossen");
    }
}
