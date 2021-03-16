package sendingMessage.gui;

import sendingMessage.entity.Person;
import sendingMessage.sendMessage.GetConnectionBrowse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WindowListInterviewsForDate extends JFrame {
    public WindowListInterviewsForDate(String date) {
        setSize(500, 400);
        setTitle("Интервью, назначенные на "+date);
        setLocation(420, 220);
        setVisible(true);

        JButton sendButton = new JButton("Рассылка WhatsApp");
        JLabel label = new JLabel();
        label.setText("<html>Перед началом рассылки авторизируйся в WhatsApp Web. <br>Не прерывай подключение во врем работы программы</html>");
        label.setSize(40, 20);
        label.setLabelFor(sendButton);

        ArrayList<Person> personArrayList = Person.listInterviewsForDate(date);
        int n = personArrayList.size();

        String[] columnNames = {"id", "Имя", "Номер", "Тип", "Дата"};
        int k = columnNames.length;

        Object[][] data = new Object[n][k];

        for (int i = 0; i<n; i++){
            data [i][0] = personArrayList.get(i).getId();
            data [i][1] = personArrayList.get(i).getName();
            data [i][2] = personArrayList.get(i).getPhoneNumber();
            data [i][3] = personArrayList.get(i).getType();
            data [i][4] = personArrayList.get(i).getDate();
        }

        JPanel contents = new JPanel();
        JTable table = new JTable(data, columnNames);
        contents.setLayout(new BoxLayout(contents, BoxLayout.PAGE_AXIS));

        contents.add(label);
        contents.add(sendButton);
        contents.add(Box.createRigidArea(new Dimension(10, 0)));
        sendButton.addActionListener(new Sendlistener(personArrayList));
        contents.add(new JScrollPane(table));

        setContentPane(contents);
    }

    class Sendlistener implements ActionListener {

        private final ArrayList<Person> personArrayList;

        Sendlistener(ArrayList<Person> personArrayList) {
            this.personArrayList = personArrayList;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            GetConnectionBrowse.getConnectionBrowse(personArrayList);
        }
    }
}
