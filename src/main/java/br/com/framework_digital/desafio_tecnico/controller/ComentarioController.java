package br.com.framework_digital.desafio_tecnico.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework_digital.desafio_tecnico.dto.ComentarioDTO;
import br.com.framework_digital.desafio_tecnico.form.ComentarioForm;
import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import br.com.framework_digital.desafio_tecnico.service.ComentarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/comentario")
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ComentarioDTO> criarComentario(@RequestBody ComentarioForm form, UriComponentsBuilder uriBuilder) {
		Comentario comentario = comentarioService.getComentarioForm(form);
		comentarioService.criarComentario(comentario);
		
		URI uri = uriBuilder.path("/comentario/{id}").buildAndExpand(comentario.getId()).toUri();
		return ResponseEntity.created(uri).body(new ComentarioDTO(comentario));
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> deletarComentario(@PathVariable Long id) throws Exception {
		Optional<Comentario> comentario = comentarioService.buscarPorId(id);
		if (comentario.isPresent()) {
			comentarioService.deletarPorId(id, comentario);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
