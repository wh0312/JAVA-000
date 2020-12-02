

import java.math.BigDecimal;
import java.sql.*;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33306/mysmall?useSSL=false&serverTimezone=UTC",
                "abc","abc123456");
        connection.setAutoCommit(false);
        String SQL = "INSERT INTO t_order(" +
                "user_id, " +
                "user_address, " +
                "status, " +
                "totalprice," +
                "create_time, update_time)" +
                "VALUES (?, ?, ?, ?, now(), now())";

//        Statement stm = connection.createStatement();
//        String addUserSQL = "INSERT INTO t_user(name, email, phone, password, role) VALUES ('wuhao1','xxggx@qq.com',11121,'abccc',0)";
//        stm.execute(addUserSQL);
//        connection.commit();
//        stm.close();


        PreparedStatement ps = connection.prepareStatement(SQL);
        for (int i = 0; i < 1000000; i++) {
            ps.setInt(1, 1);
            ps.setString(2, "address"+i);
            ps.setInt(3, 0);
            ps.setBigDecimal(4, new BigDecimal(i));
            ps.addBatch();
        }

        System.out.println("开始导入");
        long startTime = System.nanoTime();

        ps.executeBatch();
        connection.commit();

        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("导入百万条订单数据耗时:" + millis + "毫秒");

        ps.close();
        connection.close();
    }
}
