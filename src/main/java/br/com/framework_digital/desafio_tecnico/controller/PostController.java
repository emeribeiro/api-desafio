package br.com.framework_digital.desafio_tecnico.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework_digital.desafio_tecnico.dto.PostDTO;
import br.com.framework_digital.desafio_tecnico.dto.PostDetalheDTO;
import br.com.framework_digital.desafio_tecnico.modelo.Post;
import br.com.framework_digital.desafio_tecnico.service.PostService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping(value = "/listaDePosts")
	public List<PostDTO> listaPosts() {
		return postService.listaPosts();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PostDTO> criarPost(UriComponentsBuilder uriBuilder,
			@RequestParam(value = "titulo", required = false) String titulo, 
			@RequestParam(value = "link", required = false) String link, 
			@RequestParam(value = "texto", required = false) String texto, 
			@RequestParam(value = "files",required = false) MultipartFile file) throws IOException {
		Post post = postService.getPostForm(titulo, link, texto, file);
		postService.criarPost(post);
		
		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostDTO(post));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDetalheDTO> buscarPost(@PathVariable Long id) throws Exception {
		Optional<Post> post = postService.buscarPorId(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(postService.detalhar(post.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> deletarPost(@PathVariable Long id) throws Exception {
		Optional<Post> post = postService.buscarPorId(id);
		if (post.isPresent()) {
			postService.deletarPorId(id, post);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/pesquisaPorTextoOuLink")
	@ResponseBody
	public List<PostDetalheDTO> postsPesquisa(@RequestParam("filtro") String filtro) {
		return postService.listarPostPorTextoOuLink(filtro);
	}
	

}
