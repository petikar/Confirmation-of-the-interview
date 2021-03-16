package sendingMessage.database;

import databaseConnection.ConnectionJDBC;
import sendingMessage.entity.Person;
import sendingMessage.support.Formatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetList {
    public static ArrayList<Person> listInterviewsForDate(String date) {

        ArrayList<Person> personArrayList = new ArrayList<>();

        try {
            ResultSet resultSet;
            Connection connection = ConnectionJDBC.connectJDBC();

            String query = "SELECT * FROM companyInterviews where date = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, date);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String number = Formatter.formatter(resultSet.getString("phoneNumber"));
                String type = resultSet.getString("type");
                String datePerson = resultSet.getString("date");

                Person person = new Person(id, name, number, type, datePerson);
                personArrayList.add(person);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return personArrayList;
    }
}
