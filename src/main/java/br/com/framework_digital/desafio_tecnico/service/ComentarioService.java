package br.com.framework_digital.desafio_tecnico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.framework_digital.desafio_tecnico.config.security.UsuarioLogado;
import br.com.framework_digital.desafio_tecnico.form.ComentarioForm;
import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.repository.ComentarioRepository;
import br.com.framework_digital.desafio_tecnico.repository.PostRepository;
import br.com.framework_digital.desafio_tecnico.repository.UsuarioRepository;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostRepository postRepository; 
	
	public Comentario getComentarioForm(ComentarioForm form) {
		Comentario comentario = form.converter();
		comentario.setUsuario(usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get());
		comentario.setPost(postRepository.findById(form.getIdPost()).orElseThrow());
		return comentario;
	}

	public void criarComentario(Comentario comentario) {
		comentarioRepository.save(comentario);
		
	}

	public Optional<Comentario> buscarPorId(Long id) {
		return comentarioRepository.findById(id);
	}

	public void deletarPorId(Long id, Optional<Comentario> comentario) throws Exception {
		Usuario usuario = usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get();
		if(comentario.get().getUsuario().getId().equals(usuario.getId()))
			comentarioRepository.deleteById(id);
		else
			throw new Exception();
	}
}
	
	
