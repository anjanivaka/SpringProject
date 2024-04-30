//package com.cg.petshop.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//import java.util.function.Function;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//@Configuration
//public class SpringSecurityConfiguration {
//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		UserDetails user1 = createNewUser("Yoshitha", "Petshop");
//		UserDetails user2 = createNewUser("Yaswanthi", "Petshop");
//		UserDetails user3 = createNewUser("Poojitha", "Petshop");
//		UserDetails user4 = createNewUser("Prrasenna", "Petshop");
//		UserDetails user5 = createNewUser("Sowmya", "Petshop");
//		UserDetails user6 = createNewUser("Charu", "Petshop");
//		UserDetails user7 = createNewUser("Anjani", "Petshop");
//		return new InMemoryUserDetailsManager(user1, user2,user3,user4,user5,user6,user7);
//	}
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordEncoder
//		= input -> passwordEncoder().encode(input);
//		UserDetails userDetails = User.builder()
//									.passwordEncoder(passwordEncoder)
//									.username(username)
//									.password(password)
//									.roles("USER","ADMIN")
//									.build();
//		return userDetails;
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				auth -> auth.anyRequest().authenticated());
//		http.httpBasic(withDefaults());
//		http.csrf(csrf -> csrf.disable());//POST or PUT
//		http.headers(headers->headers.frameOptions(frameOptionsConfig->frameOptionsConfig.disable()));
//		return http.build();
//	
//	}
// 
//}
