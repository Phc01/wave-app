package br.com.fatec.wave.security;

import br.com.fatec.wave.model.UserRole;
import br.com.fatec.wave.model.Usuario;
import br.com.fatec.wave.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializerConfig {

    @Bean
    public CommandLineRunner initializeData(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            @Value("${app.admin1.email}") String admin1Email,
            @Value("${app.admin1.password}") String admin1Password,
            @Value("${app.admin2.email}") String admin2Email,
            @Value("${app.admin2.password}") String admin2Password
    ) {
        return args -> {
            // Admin 1
            if (!usuarioRepository.existsByEmail(admin1Email)) {
                Usuario admin1 = new Usuario();
                admin1.setNome("Admin Master");
                admin1.setEmail(admin1Email);
                admin1.setSenha(passwordEncoder.encode(admin1Password));
                admin1.setRole(UserRole.ADMIN);
                usuarioRepository.save(admin1);
                System.out.println(">>> Usuário Admin 1 criado com sucesso!");
            }

            // Admin 2
            if (!usuarioRepository.existsByEmail(admin2Email)) {
                Usuario admin2 = new Usuario();
                admin2.setNome("Admin Suporte");
                admin2.setEmail(admin2Email);
                admin2.setSenha(passwordEncoder.encode(admin2Password));
                admin2.setRole(UserRole.ADMIN);
                usuarioRepository.save(admin2);
                System.out.println(">>> Usuário Admin 2 criado com sucesso!");
            }
        };
    }
}
