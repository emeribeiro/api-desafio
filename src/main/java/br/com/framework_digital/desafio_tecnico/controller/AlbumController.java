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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework_digital.desafio_tecnico.dto.AlbumDTO;
import br.com.framework_digital.desafio_tecnico.modelo.Album;
import br.com.framework_digital.desafio_tecnico.service.AlbumService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlbumDTO> criarAlbum(UriComponentsBuilder uriBuilder, 
			@RequestParam(value = "files",required = false) MultipartFile[] files, 
			@RequestParam(value = "titulo", required = false) String titulo) throws IOException {
		Album album = albumService.getAlbumForm(files, titulo);
		albumService.criarAlbum(album);
		
		URI uri = uriBuilder.path("/album/{id}").buildAndExpand(album.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlbumDTO(album));
	}
	
	@GetMapping(value = "/listaDeAlbuns")
	public List<AlbumDTO> listarAlbuns() {
		return albumService.listarAlbuns();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlbumDTO> buscarAlbum(@PathVariable Long id) throws Exception {
		Optional<Album> album = albumService.buscarPorId(id);
		if (album.isPresent()) {
			return ResponseEntity.ok(new AlbumDTO(album.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> deletarAlbum(@PathVariable Long id) throws Exception {
		Optional<Album> album = albumService.buscarPorId(id);
		if (album.isPresent()) {
			albumService.deletarPorId(id, album);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
