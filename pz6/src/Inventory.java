import java.sql.*;

public class Inventory {

    public final String dbName;
    public final String driver = "jdbc:sqlite:";
    public final String url;

    public Inventory(String dbName) {
        this.dbName = dbName;
        url = driver.concat(dbName);
    }

    public void createNewDB(String dbName) {
        String url = "jdbc:sqlite:" + dbName;
        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                System.out.println("new database with name " + dbName + " has been created");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable(String dbName, String tablename) {
        String url = "jdbc:sqlite:" + dbName;
        String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "itemName text NOT NULL, " +
                "size INTEGER, " +
                "countOfItems INTEGER, " +
                "cost INTEGER);";
        System.out.println("table created");
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insert(String tableName, String itemName, int size, int countOfItems, int cost) {
        String query = "INSERT INTO " + tableName + "(itemName, size, countOfItems, cost) " +
                "VALUES (?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, itemName);
            statement.setInt(2, size);
            statement.setInt(3, countOfItems);
            statement.setInt(4, cost);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void selectAll(String tableName){
        String query = "SELECT * FROM " + tableName +";";
        try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()){
                System.out.printf("%2d %-6s %d %d %d\n",
                        resultSet.getInt("id"),
                        resultSet.getString("itemName"),
                        resultSet.getInt("size"),
                        resultSet.getInt("countOfItems"),
                        resultSet.getInt("cost"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(String tableName, int idToDelete){
        String query = "DELETE FROM "+tableName+" WHERE ID="+idToDelete+";";
        try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
