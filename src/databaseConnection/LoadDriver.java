package databaseConnection;

public class LoadDriver {
    public static void loadDriver(String driver) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println("Driver not loaded");
            exception.printStackTrace();
        }
    }
}
