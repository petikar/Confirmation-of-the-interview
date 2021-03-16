package sendingMessage.sendMessage;

import sendingMessage.entity.Person;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class GetConnectionBrowse {
        ArrayList<Person> personArrayList;

    public GetConnectionBrowse(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public static void getConnectionBrowse(ArrayList<Person> personArrayList) {
        //соединяюсь с браузером
        Runnable r = () -> {

            URL url = null;
            try {
                url = new URL("https://web.whatsapp.com/");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int size = personArrayList.size();
            String number;
            String encodedText;

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    for (int i = 0; i < size; i++) {
                        Person person = personArrayList.get(i);
                        number = person.getPhoneNumber();
                        encodedText = (new MessageGenerator(person)).messageGenerator();
                        Desktop.getDesktop().browse(new URI(url + "send?phone=" + number + "&text=" + encodedText));
                        person.deleteToDatabase(person);
                        Thread.sleep(60000);
                    }
                } catch (URISyntaxException | IOException | InterruptedException exception) {
                    System.out.println("проблема при подключении в браузере");
                    exception.printStackTrace();
                }
            }
        };


        Thread t = new Thread(r);
        t.start();
    }
}


