package com.companyname.springapp.business;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
	public DriverManagerDataSource Conectar() {
			
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/nomina");
		dataSource.setUsername("root");
		dataSource.setPassword("j1j2j3j4j5");
		return dataSource;
		
	}
}
