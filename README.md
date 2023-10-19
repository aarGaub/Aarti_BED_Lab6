# Aarti_BED_Lab6 
This Project uses Spring Boot version 3.1.4 with Spring Security, ThymeLeaf, Lombok, MySql DB.
First time users and roles Vihaan(ADMIN) and Aarti(USER) were created once in the DB using CommandLineRunner and BCryptPasswordEncoder. 
Beginning with version 5.7.0-M2, Spring deprecates the use of WebSecurityConfigureAdapter
and suggests creating configurations without it. I have Upgraded the deprecated 'WebSecurityConfigureAdapter'
and instead using 'SecurityFilterChain' for this project.
Spring Boot project(3.1.4) uses Spring Security version 5.6.1 
