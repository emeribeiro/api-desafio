package br.com.framework_digital.desafio_tecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import br.com.framework_digital.desafio_tecnico.modelo.Post;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
	List<Comentario> findByPost(Post post);

}
