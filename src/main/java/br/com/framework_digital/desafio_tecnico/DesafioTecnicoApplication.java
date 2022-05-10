package br.com.framework_digital.desafio_tecnico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.repository.UsuarioRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan("br.com.framework_digital.desafio_tecnico.modelo")
public class DesafioTecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoApplication.class, args);
	}
	
//	@Bean
//    CommandLineRunner init(UsuarioRepository userRepository) {
//        return args -> {
//            Usuario usuario = new Usuario();
//            usuario.setNome("Teste");
//            usuario.setUsername("test");
//            usuario.setSenha(new BCryptPasswordEncoder().encode("teste"));
//            userRepository.save(usuario);
//        };
//    }

}
