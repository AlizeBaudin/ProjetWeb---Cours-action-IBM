package com.miage.ProjetWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class ProjetWebApplication {

	public static void main(String[] args) {

		// Postgres. java

		try{
			Class.forName("org.postgresql.Driver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		String url = "jdbc:postgresql://dumbo.db.elephantsql.com/jlkhvktz";
		String username = "jlkhvktz";
		String password = "BzNqeGNuN24Nc422ZT9CGbUyxbZZHBgq";

		try {
			Connection db = DriverManager.getConnection(url, username, password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM people");
			while (rs.next()) {
				System.out.print("Column 1 returned ");
				System.out.println(rs.getString(2));
				System.out.print("Column 2 returned ");
				System.out.println(rs.getString(3));
			}
			rs.close();
			st.close();
		}
		catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
//SimpleElephantSQLExemple.java

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/main/context.xml");
		DataSource ds = (DataSource)applicationContext.getBean("dataSource");
		JdbcTemplate jt = new JdbcTemplate(ds);

		jt.execute("create table elephant (date varchar, open float, hight float, low float)");
// Exemple d'ajout via la lecture de l'url :
		//jt.execute("insert into elephant (data, open, hight, low) value (12-12-2022, 157.0, 161.0, 142.0");

		Object[] parameters = new Object[] {new int[2]};
		Object o = jt.queryForObject("select name from elephant where id = ?",
				parameters, String.class);
		System.out.println((String)o);


		SpringApplication.run(ProjetWebApplication.class, args);
	}

}
