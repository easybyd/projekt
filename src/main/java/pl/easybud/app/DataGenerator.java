package pl.easybud.app;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.easybud.backend.data.Role;
import pl.easybud.backend.data.entity.User;
import pl.easybud.backend.repository.UserRepository;

@SpringComponent
public class DataGenerator implements HasLogger {

	private User employee;
	private User manager;
	private User admin;

	@Bean
	public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (hasData(userRepository)) {
				getLogger().info("Using existing database");
				return;
			}

			createUsers(userRepository, passwordEncoder);
			getLogger().info("Generated users");
		};
	}

	private boolean hasData(UserRepository userRepository) {
		return userRepository.count() != 0L;
	}

	private void createUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		manager = new User("kierownik@easybud.pl", "Stanisław Anioł", passwordEncoder.encode("pass"), Role.MANAGER);
		manager.setLocked(false);
		userRepository.save(manager);

		employee = new User("pracownik@easybud.pl", "Józef Balcerek", passwordEncoder.encode("pass"), Role.EMPLOYEE);
		employee.setLocked(false);
		userRepository.save(employee);

		admin = new User("admin@easybud.pl", "Krzysztof Jarzyna", passwordEncoder.encode("pass"), Role.ADMIN);
		admin.setLocked(true);
		userRepository.save(admin);
	}

}
