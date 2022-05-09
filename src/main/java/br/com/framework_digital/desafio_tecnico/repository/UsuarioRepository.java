package br.com.framework_digital.desafio_tecnico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.framework_digital.desafio_tecnico.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findAll();
	Boolean existsByUsername(String username);
	Optional<Usuario> findByUsername(String usuario);
}
