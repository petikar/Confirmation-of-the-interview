package sendingMessage.support;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Formatter {

    public static String formatter(String number) {
        return number.replaceAll("[- +()qwertyuiopasdfghjkl;'zxcvbnm,./ёйцукенгшщзхъэждлорпавыфячсмитьбю.]", "");
    }


    public static JFormattedTextField formattedDate() {

        DateFormat date = new SimpleDateFormat("dd/MM");
        JFormattedTextField ftfDate;

        DateFormatter dateFormatter = new DateFormatter(date);
        dateFormatter.setOverwriteMode(true);

        ftfDate = new JFormattedTextField(dateFormatter);
        ftfDate.setColumns(5);

        return ftfDate;
    }
}
