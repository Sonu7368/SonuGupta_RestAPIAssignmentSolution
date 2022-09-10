package com.greatlearning.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.greatlearning.employee_management"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("\n\n" +
				"Employee Management App has started. \n" +
				"Use this address to connect: http://localhost:8080/ \n" +
				"H2 Console: http://localhost:8080/h2-console/ \n");

		System.out.println(
				"Listing all the endpoins: \n" +
				"1. /api/role [POST] --> to add a new role \n" +
				"2. /api/user [POST] --> to add n new user \n" +
				"3. /api/employees [GET] --> to get a list of all Employees \n" +
				"4. /api/employees [POST] --> to add a new Employee \n" +
				"5. /api/employees [PUT] --> to update an Employee \n" +
				"6. /api/employees/{id} [GET] --> to get the Employee with given id \n" +
				"7. /api/employees/{id} [DELETE] --> to delete the Employee with given id \n" +
				"8. /api/employees/search/{firstName} [GET] --> to search Employees with first name \n" +
				"9. /api/employees/sort [GET] --> to get sorted list of Employees \n\n");
	}

}
