package df;

import java.sql.*;

/**
 * 数据库表解析
 *
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 18:42
 **/
public class TableParse {

    private static final String URL = "jdbc:mysql://123.57.208.169:3306/react_admin?user=root&password=123456";
    private static Connection conn = null;
    private static DatabaseMetaData meta = null;
    private static String[] tableInfo = new String[2];

    static {
        try {
            conn = DriverManager.getConnection(URL);
            meta = (DatabaseMetaData) conn.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static ResultSet parse() throws SQLException {
        return meta.getColumns(null, "%", "role", "%");
    }

    static String[] getTableInfo() throws SQLException {
        ResultSet pkInfo = meta.getPrimaryKeys(null, "%", "role");
        String primaryKeyName = null;
        String tableName = null;
        while (pkInfo.next()) {
            primaryKeyName = pkInfo.getString("COLUMN_NAME");
            tableName = pkInfo.getString("TABLE_NAME");

        }
        tableInfo[0] = tableName;
        tableInfo[1] = primaryKeyName;
        return tableInfo;
    }


}
