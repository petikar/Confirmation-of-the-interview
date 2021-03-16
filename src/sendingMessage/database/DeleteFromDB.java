package sendingMessage.database;

import databaseConnection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFromDB {
    public static void deleteToDatabase(int id) {
        try {
            Connection connection = ConnectionJDBC.connectJDBC();
            String query = "DELETE FROM my_company.companyInterviews WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}