import java.sql.*;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:8888/db_cooking_recipes";
        String user = "postgres";
        String password  = "1488";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from ingridients");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
