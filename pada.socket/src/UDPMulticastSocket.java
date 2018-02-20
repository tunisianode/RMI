import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class UDPMulticastSocket extends UDPSocket
{

    public UDPMulticastSocket(int port) throws SocketException
    {
        super(port);
    }

    public void join (String mcAdress) throws IOException{
        InetAddress group = InetAddress.getByName(mcAdress);
        ((MulticastSocket)socket).joinGroup(group);
    }

    public void leave(String mcAdress) throws IOException{
        InetAddress group = InetAddress.getByName(mcAdress);
        ((MulticastSocket)socket).leaveGroup(group);
    }
}
