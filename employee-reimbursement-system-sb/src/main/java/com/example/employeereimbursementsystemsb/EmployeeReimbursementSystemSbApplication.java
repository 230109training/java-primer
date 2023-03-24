package com.example.employeereimbursementsystemsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EmployeeReimbursementSystemSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeReimbursementSystemSbApplication.class, args);
	}

}
