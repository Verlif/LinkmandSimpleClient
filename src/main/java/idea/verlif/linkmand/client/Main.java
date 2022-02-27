package idea.verlif.linkmand.client;

import idea.verlif.linkmand.server.client.LinkClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Verlif
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        ConfigExtend config = ConfigExtend.load();
        config.handler((client, s) -> System.out.println(s));
        config.connectedListener(client -> System.out.println("Connected ip " + config.getIp() + " with name " + config.getName()));
        config.closedListener(() -> System.out.println("Closed!"));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        LinkClient client = new LinkClient(config.getName(), config);
        client.setMessageHandler((from, message) -> System.out.println("[" + sdf.format(new Date()) + "][" + from + "]: " + message));
        client.connect();
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        while (client.isConnected()) {
            client.sendMessage(scanner.nextLine());
            Thread.sleep(500);
        }
        System.out.println("Finished!");
    }
}
