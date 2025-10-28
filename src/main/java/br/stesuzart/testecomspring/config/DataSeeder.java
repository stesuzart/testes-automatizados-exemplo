package br.stesuzart.testecomspring.config;

import br.stesuzart.testecomspring.entity.AppUser;
import br.stesuzart.testecomspring.entity.Role;
import br.stesuzart.testecomspring.repository.AppUserRepository;
import br.stesuzart.testecomspring.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner init(RoleRepository roleRepo, AppUserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            Role userRole = roleRepo.findByName("ROLE_USER").orElseGet(() -> roleRepo.save(new Role("ROLE_USER")));
            Role adminRole = roleRepo.findByName("ROLE_ADMIN").orElseGet(() -> roleRepo.save(new Role("ROLE_ADMIN")));


            if (userRepo.findByUsername("user").isEmpty()) {
                AppUser u = new AppUser("user", encoder.encode("123"));
                u.getRoles().add(userRole);
                userRepo.save(u);
            }
            if (userRepo.findByUsername("admin").isEmpty()) {
                AppUser a = new AppUser("admin", encoder.encode("123"));
                a.getRoles().add(userRole);
                a.getRoles().add(adminRole);
                userRepo.save(a);
            }
        };
    }
}