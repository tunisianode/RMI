package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDPSocket implements AutoCloseable
{
    protected DatagramSocket socket;
    private InetAddress adress;
    private int port;




    public UDPSocket() throws SocketException
    {
        this(new DatagramSocket());
    }

    public UDPSocket(int port) throws SocketException{
        this(new DatagramSocket(port));
    }

    protected UDPSocket(DatagramSocket socket){
        this.socket = socket;
    }

    public void setTimeout (int timeout) throws SocketException
    {
        socket.setSoTimeout(timeout);
    }

    public InetAddress getsendAdress()
    {
        return adress;
    }

    public int getSenderPort()
    {
        return port;
    }

    public void send(String s,InetAddress adress,int port) throws IOException{
        byte[] outbuffer = s.getBytes();
        DatagramPacket outPacket = new DatagramPacket(outbuffer,outbuffer.length,adress,port);

        socket.send(outPacket);
    }

    public String receive(int maxBytes) throws IOException{
        byte[] inBuffer = new byte[maxBytes];
        DatagramPacket inPacket = new DatagramPacket(inBuffer,inBuffer.length);
        socket.receive(inPacket);
        adress=inPacket.getAddress();
        port=inPacket.getPort();
        return new String(inBuffer,0,inPacket.getLength());
    }

    public void reply(String s) throws IOException{
        if(adress ==null){
            throw new IOException("no one to reply");
        }
        send(s,adress,port);
    }



    @Override
    public void close() throws Exception
    {
        socket.close();
    }


}
