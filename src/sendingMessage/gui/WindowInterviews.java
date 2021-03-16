package sendingMessage.gui;

import sendingMessage.support.Formatter;
import sendingMessage.database.SaveToDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class WindowInterviews extends JDialog {
    //окно для записи интервью.
    public WindowInterviews() {
        JLabel labelName            = new JLabel("Введи имя: ");
        JTextField textFieldName    = new JTextField(15);

        JLabel labelPhone           = new JLabel("Введи номер телефона: ");
        JTextField textFieldPhone   = new JTextField(15);
        JLabel labelDate            = new JLabel("Дата: ");

        JButton buttonSave          = new JButton("Сохранить");

        JRadioButton skypeButton    = new JRadioButton("Skype", true);
        JRadioButton inPersonButton = new JRadioButton("Офис", false);

        JFormattedTextField ftfDate = Formatter.formattedDate();

        setSize(470, 150);
        setTitle("Подтверждение интервью");
        setLocation(450, 300);

        setVisible(true);
        // Создание панели с кнопками и для ввода данных
        JPanel contents = new JPanel();
        contents.setLayout(new GridBagLayout());

        GridBagConstraints constraints1 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        //сколько клеток занимает
        constraints1.gridheight = 1;
        constraints1.gridwidth = 2;
        contents.add(labelName, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        //сколько клеток занимает
        constraints2.gridheight = 1;
        constraints2.gridwidth = 12;
        contents.add(textFieldName, constraints2);
        textFieldName.setToolTipText("Имя");

        GridBagConstraints constraints3 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints3.gridx = 0;
        constraints3.gridy = 1;
        //сколько клеток занимает
        constraints3.gridheight = 1;
        constraints3.gridwidth = 2;
        contents.add(labelPhone, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints4.gridx = 2;
        constraints4.gridy = 1;
        //сколько клеток занимает
        constraints4.gridheight = 1;
        constraints4.gridwidth = 4;
        contents.add(textFieldPhone, constraints4);
        textFieldPhone.setToolTipText("Номер телефона, начиная с 7");

        GridBagConstraints constraints5 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints5.gridx = 2;
        constraints5.gridy = 2;
        //сколько клеток занимает
        constraints5.gridheight = 1;
        constraints5.gridwidth = 1;
        contents.add(skypeButton, constraints5);

        GridBagConstraints constraints6 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints6.gridx = 3;
        constraints6.gridy = 2;
        //сколько клеток занимает
        constraints6.gridheight = 1;
        constraints6.gridwidth = 1;
        contents.add(inPersonButton, constraints6);

        GridBagConstraints constraints7 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints7.gridx = 3;
        constraints7.gridy = 3;
        //сколько клеток занимает
        constraints7.gridheight = 1;
        constraints7.gridwidth = 1;
        contents.add(buttonSave, constraints7);

        GridBagConstraints constraints9 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints9.gridx = 1;
        constraints9.gridy = 2;
        //сколько клеток занимает
        constraints9.gridheight = 1;
        constraints9.gridwidth = 1;
        contents.add(ftfDate, constraints9);
        ftfDate.setValue(new Date());

        GridBagConstraints constraints10 = new GridBagConstraints();
        //откуда начинаем рисовать
        constraints10.gridx = 0;
        constraints10.gridy = 2;
        //сколько клеток занимает
        constraints10.gridheight = 1;
        constraints10.gridwidth = 1;
        contents.add(labelDate, constraints10);

        setContentPane(contents);

        //группа, чтобы нажималась только одна кнопка
        ButtonGroup group = new ButtonGroup();
        group.add(skypeButton);
        group.add(inPersonButton);

        buttonSave.addActionListener(new SaveListener(textFieldName, textFieldPhone, inPersonButton, ftfDate));
    }

    class SaveListener implements ActionListener {
        JTextField textFieldName;
        JTextField textFieldPhone;
        JRadioButton inPersonButton;
        JFormattedTextField ftfDate;

        public SaveListener(JTextField textFieldName, JTextField textFieldPhone, JRadioButton inPersonButton, JFormattedTextField ftfDate) {
            this.textFieldName = textFieldName;
            this.textFieldPhone = textFieldPhone;
            this.inPersonButton = inPersonButton;
            this.ftfDate = ftfDate;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SaveToDB saveToDB = new SaveToDB(textFieldName, textFieldPhone, inPersonButton, ftfDate);
            saveToDB.saveToDatabase();
            dispose();
        }
    }
}
