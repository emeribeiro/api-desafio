package br.com.framework_digital.desafio_tecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.framework_digital.desafio_tecnico.modelo.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findAll();

	List<Post> findByTextoContainingAndLinkContaining(String texto, String link);

	List<Post> findByTextoContaining(String texto);

}
