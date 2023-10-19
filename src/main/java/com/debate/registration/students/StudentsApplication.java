package com.debate.registration.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.debate.registration.students.dao.UserRepository;
import com.debate.registration.students.entity.Role;
import com.debate.registration.students.entity.User;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * To create one time users and roles in DB using BCryptPasswordEncoder.
		 * Uncomment this to create roles and user only once. 
		 * 
		 * Role adminRole = new Role(); adminRole.setRoleName("ADMIN"); Role userRole =
		 * new Role(); userRole.setRoleName("USER");
		 * 
		 * List<Role> rolesAdmin= new ArrayList<>(); rolesAdmin.add(adminRole);
		 * 
		 * List<Role> rolesUser= new ArrayList<>(); rolesUser.add(userRole);
		 * 
		 * //Vihaan is admin role, Aarti has user role
		 * 
		 * User admin = new User(); admin.setUserName("Vihaan");
		 * admin.setPassword(getPasswordEncoder().encode("admin123"));
		 * admin.setRoles(rolesAdmin); userRepo.save(admin);
		 * 
		 * User user = new User(); user.setUserName("Aarti");
		 * user.setPassword(getPasswordEncoder().encode("user123"));
		 * user.setRoles(rolesUser); userRepo.save(user);
		 * System.out.println("password for vihaan "+admin.getPassword());
		 * System.out.println("password for aarti "+user.getPassword());
		 */
	}

	/*
	  @Bean PasswordEncoder getPasswordEncoder() {
	  return new BCryptPasswordEncoder(); 
	  //return NoOpPasswordEncoder.getInstance(); 
	  }
	 
	 @Autowired 
	 UserRepository userRepo;
	 */

}
