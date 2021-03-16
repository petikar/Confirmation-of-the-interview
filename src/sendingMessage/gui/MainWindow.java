package sendingMessage.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {

    JButton buttonAddInterviews           = new JButton("Добавить интервью");
    JButton buttonAllInterviews           = new JButton("Список интервью");

    public MainWindow() {
        setSize(300, 200);
        setTitle("Company");
        setLocation(420, 220);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Создание панели с кнопками и для ввода данных
        JPanel contents = new JPanel();

        contents.add(buttonAddInterviews);
        contents.add(buttonAllInterviews);

        buttonAddInterviews.addActionListener(new InterviewsListener());
        buttonAllInterviews.addActionListener(new ListInterviewsListener());

        setContentPane(contents);

    }
    class InterviewsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            WindowInterviews windowInterviews = new WindowInterviews();
        }
    }

    class ListInterviewsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WindowListInterviews windowListInterviews = new WindowListInterviews();
        }
    }
}
