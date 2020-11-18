package com.example.Homework06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class Homework06Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Homework06Application.class, args);
	}

	@Override
	public void run(String... args) throws SQLException, ClassNotFoundException {
		userHikari(); //使用数据库连接池
		userJDBC(); // 使用jdbc
		useTransaction(); //使用jdbc+事务
	}


	public void userJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:core", "sa", "");
		System.out.println("useJDBC===================" + conn.toString());
		conn.close();
	}

	public void useTransaction() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:core", "sa", "");

		PreparedStatement ps ;

		try {
			conn.setAutoCommit(false);  //将自动提交设置为false
			ps = conn.prepareStatement(""); // 这里写增删改查sql语句
			ps.executeUpdate(); //执行修改操作
			conn.commit();      //当操作成功后手动提交
		} catch (Exception e) {

			conn.rollback();    //一旦其中一个操作出错都将回滚，使两个操作都不成功

			e.printStackTrace();

		}
	}

	public void userHikari() throws SQLException {
		Connection conn = dataSource.getConnection();
		conn.prepareStatement("select 1");
		System.out.println("useHikari==================="  + conn.toString());
		conn.close();
	}



}
