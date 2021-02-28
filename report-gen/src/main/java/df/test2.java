package df;

import java.sql.*;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 2:15
 **/
public class test2 {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://123.57.208.169:3306/react_admin?user=root&password=123456";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection(URL);
        DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();

        ResultSet rs = meta.getColumns(null, "%", "role", "%");

        while (rs.next()) {
            // table catalog (may be null)
            String tableCat = rs.getString("TABLE_CAT");
            // table schema (may be null)
            String tableSchemaName = rs.getString("TABLE_SCHEM");
            // table name
            String tableName_ = rs.getString("TABLE_NAME");
            // column name
            String columnName = rs.getString("COLUMN_NAME");

            // SQL type from java.sql.Types
            int dataType = rs.getInt("DATA_TYPE");

            // Data source dependent type name, for a UDT the type name is
            // fully qualified
            String dataTypeName = rs.getString("TYPE_NAME");
            System.out.println(columnName + "    " + dataTypeName);
            // table schema (may be null)
            int columnSize = rs.getInt("COLUMN_SIZE");
            // the number of fractional digits. Null is returned for data
            // types where DECIMAL_DIGITS is not applicable.
            int decimalDigits = rs.getInt("DECIMAL_DIGITS");
            // Radix (typically either 10 or 2)
            int numPrecRadix = rs.getInt("NUM_PREC_RADIX");
            // is NULL allowed.
            int nullAble = rs.getInt("NULLABLE");
            // comment describing column (may be null)
            //注释
            String remarks = rs.getString("REMARKS");
            // default value for the column, which should be interpreted as
            // a string when the value is enclosed in single quotes (may be
            // null)
            String columnDef = rs.getString("COLUMN_DEF");
            //
            int sqlDataType = rs.getInt("SQL_DATA_TYPE");
            //
            int sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB");
            // for char types the maximum number of bytes in the column
            int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");
            // index of column in table (starting at 1)
            int ordinalPosition = rs.getInt("ORDINAL_POSITION");
            // ISO rules are used to determine the nullability for a column.
            // YES --- if the parameter can include NULLs;
            // NO --- if the parameter cannot include NULLs
            // empty string --- if the nullability for the parameter is
            // unknown
            String isNullAble = rs.getString("IS_NULLABLE");
            // Indicates whether this column is auto incremented
            // YES --- if the column is auto incremented
            // NO --- if the column is not auto incremented
            // empty string --- if it cannot be determined whether the
            // column is auto incremented parameter is unknown
            String isAutoincrement = rs.getString("IS_AUTOINCREMENT");
            System.out.println(tableCat + "-" + tableSchemaName + "-" + tableName_ + "-" + columnName + "-"
                    + dataType + "-" + dataTypeName + "-" + columnSize + "-" + decimalDigits + "-" + numPrecRadix
                    + "-" + nullAble + "-" + remarks + "-" + columnDef + "-" + sqlDataType + "-" + sqlDatetimeSub
                    + charOctetLength + "-" + ordinalPosition + "-" + isNullAble + "-" + isAutoincrement + "-");
        }
    }
}
