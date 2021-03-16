package sendingMessage.database;

import databaseConnection.ConnectionJDBC;
import sendingMessage.gui.WindowInterviews;
import sendingMessage.support.Formatter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveToDB {

    JTextField textFieldName;
    JTextField textFieldPhone;
    JRadioButton inPersonButton;
    JFormattedTextField ftfDate;

    public SaveToDB(JTextField textFieldName, JTextField textFieldPhone, JRadioButton inPersonButton, JFormattedTextField ftfDate) {
        this.textFieldName = textFieldName;
        this.textFieldPhone = textFieldPhone;
        this.inPersonButton = inPersonButton;
        this.ftfDate = ftfDate;
    }

    public void saveToDatabase() {

        String name = textFieldName.getText();
        String phoneNumber = Formatter.formatter(textFieldPhone.getText());
        String typeInterview;
        if (inPersonButton.isSelected()) {
            typeInterview = "офис";
        } else {
            typeInterview = "скайп";
        }
        String date = ftfDate.getText();

        if (!name.equals("")  &&  !phoneNumber.equals("")) {
            try {
                Connection connection = ConnectionJDBC.connectJDBC();
                String query = "INSERT INTO my_company.companyInterviews (name, phoneNumber, type, date) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phoneNumber);
                preparedStatement.setString(3, typeInterview);
                preparedStatement.setString(4, date);
                preparedStatement.executeUpdate();
            } catch (
                    SQLException sqlException) {
                sqlException.printStackTrace();
            }
        } else {
            System.out.println("Данные о соискателе введены некорректно");
            Runnable r = () -> {
                JFrame frame = new JFrame("Ошибка");
                JLabel label = new JLabel("Проверь правильность введённых данных");

                frame.add(label);
                frame.setSize(400, 300);
                frame.setLocation(420, 220);
                frame.setVisible(true);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    frame.setVisible(false);
                    WindowInterviews windowInterviews = new WindowInterviews();
                }

            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
