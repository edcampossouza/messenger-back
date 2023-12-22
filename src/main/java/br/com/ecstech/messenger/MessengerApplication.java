package br.com.ecstech.messenger;

import br.com.ecstech.messenger.model.Role;
import br.com.ecstech.messenger.repository.RoleRepository;
import br.com.ecstech.messenger.service.ApplicationUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MessengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessengerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ApplicationUserService applicationUserService, RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByAuthority("ADMIN").isPresent()) {
                System.out.println("Roles exist. Continue application");
                return;
            }
            System.out.println("Creating roles...");
            Role adminRole = new Role("ADMIN");
            roleRepository.save(adminRole);
            Role userRole = new Role("USER");
            roleRepository.save(userRole);

            applicationUserService.registerUser("admin", "123", adminRole);
        };
    }

}
