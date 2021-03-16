package sendingMessage.gui;

import sendingMessage.support.Formatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WindowListInterviews extends JDialog {

    public WindowListInterviews(){

        setSize(300, 100);
        setTitle("Список интервью");
        setLocation(450, 300);

        JLabel labelDate            = new JLabel("Введи дату: ");
        JFormattedTextField ftfDate = Formatter.formattedDate();
        JButton buttonShow          = new JButton("Показать");


        setVisible(true);

        JPanel contents = new JPanel();
        setContentPane(contents);
        contents.setLayout(new GridBagLayout());

        GridBagConstraints constraints1 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        //сколько клеток занимает
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        contents.add(labelDate, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints2.gridx = 1;
        constraints2.gridy = 0;
        //сколько клеток занимает
        constraints2.gridheight = 1;
        constraints2.gridwidth = 1;
        contents.add(ftfDate, constraints2);
        ftfDate.setValue(new Date());
        ftfDate.setToolTipText("Дата dd/mm");

        GridBagConstraints constraints3 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints3.gridx = 0;
        constraints3.gridy = 1;
        //сколько клеток занимает
        constraints3.gridheight = 1;
        constraints3.gridwidth = 2;
        contents.add(buttonShow, constraints3);
        buttonShow.setBackground(Color.lightGray);
        buttonShow.addActionListener(new ShowListener(ftfDate));

        setContentPane(contents);
        contents.setBackground(Color.lightGray);

    }

    class ShowListener implements ActionListener {
        JFormattedTextField ftfDate;

        public ShowListener(JFormattedTextField ftfDate) {
            this.ftfDate = ftfDate;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String date = ftfDate.getText();
            WindowListInterviewsForDate windowListInterviewsForDate = new WindowListInterviewsForDate(date);
            dispose();
        }
    }
}
