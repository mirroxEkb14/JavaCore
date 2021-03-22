package JavaNet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class JavaInetAddress {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        // get my IP and local host name
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address); // DESKTOP-55JV29H/169.254.122.231
        System.out.printf("My IP: %s\nMy host name: %s\n", address.getHostAddress(), address.getHostName());

        System.out.println();

        // get my IP and some site`s IP
        InetAddress currentIP = null;
        InetAddress bsuIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            System.out.println("My IP: " + currentIP.getHostAddress());

            bsuIP = InetAddress.getByName("www.bsu.by");
            System.out.println("bsu IP: " + bsuIP.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("The address is not available - " + e);
        }

        System.out.println();

        // get information about the site
        URL hp = new URL("https://www.wikipedia.org/");
        System.out.println("Protocol: " + hp.getProtocol()); // https
        System.out.println("Port: " + hp.getPort()); // -1
        System.out.println("Host: " + hp.getHost()); // www.wikipedia.org
        System.out.println("File: " + hp.getFile()); // /
        System.out.println("Ext: " + hp.toExternalForm()); // https://www.wikipedia.org/

        System.out.println();

        // задание IP-адреса в виде массива
        byte[] ip = {127, 21, 43, 10};
        try {
            InetAddress addr = InetAddress.getByAddress("University", ip);
            System.out.println(addr.getHostName() +
                    " -> соединение: " + addr.isReachable(1000));

        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);

        } catch (IOException e) {
            System.err.println("ошибка потока " + e);
        }
    }
}
