package br.com.framework_digital.desafio_tecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.framework_digital.desafio_tecnico.form.UsuarioForm;
import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioForm(UsuarioForm form) {
		return new Usuario(form.getNome(), form.getUsername(), form.getSenha());
	}

//	public void criarUsuario(Usuario usuario) {
//		usuarioRepository.save(usuario);
//	}

	public Boolean existsByUsername(Usuario usuario) {
		return usuarioRepository.existsByUsername(usuario.getUsername());
	}


}
