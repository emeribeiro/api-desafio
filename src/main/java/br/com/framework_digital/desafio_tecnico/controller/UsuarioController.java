package br.com.framework_digital.desafio_tecnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.service.UsuarioService;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/listaDeUsuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
//	@PostMapping(value = "/cadastro")
//	@Transactional
//	public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
//		Usuario usuario = usuarioService.getUsuarioForm(form);
//		
//		if (usuarioService.existsByUsername(usuario))
//			return ResponseEntity.badRequest().build();
//		else
//			usuarioService.criarUsuario(usuario);
//		
//		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
//		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
//	}
}
