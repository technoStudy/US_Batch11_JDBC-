package utils;


import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JdbcUtils extends Hooks{

    SQLqueries sqLqueries = new SQLqueries();

    // creating dynamic method to count number of null data
    public int countNullCellsInTable(String tableName) {
        int nullCellCount = 0;

        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqLqueries.readingTableData(tableName));
            // ResulSetMetData is an interface provides information about columns in a table,such as column name,
            // column types, number of columns...e
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    if (resultSet.getObject(i) == null) {
                        nullCellCount++;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(nullCellCount);
        return nullCellCount;
    }

}
