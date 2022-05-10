package br.com.framework_digital.desafio_tecnico.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.framework_digital.desafio_tecnico.config.security.UsuarioLogado;
import br.com.framework_digital.desafio_tecnico.dto.PostDTO;
import br.com.framework_digital.desafio_tecnico.dto.PostDetalheDTO;
import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import br.com.framework_digital.desafio_tecnico.modelo.Post;
import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.repository.ComentarioRepository;
import br.com.framework_digital.desafio_tecnico.repository.PostRepository;
import br.com.framework_digital.desafio_tecnico.repository.UsuarioRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	public List<PostDTO> listaPosts() {
		List<Post> posts = postRepository.findAll();
		return PostDTO.converter(posts);		
	}

	public Optional<Post> buscarPorId(Long id) {
		return postRepository.findById(id);
	}
	
	public void deletarPorId(Long id, Optional<Post> post) throws Exception {
		Usuario usuario = usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get();
		if(post.get().getUsuario().getId().equals(usuario.getId()))
			postRepository.deleteById(id);
		else
			throw new Exception();
	}

	public void criarPost(Post post) {
		postRepository.save(post);
	}

	public Post getPostForm(String titulo, String link, String texto, MultipartFile file) throws IOException {
		Post post = new Post();
		post.setUsuario(usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get());
		post.setLink(link);
		post.setTexto(texto);
		post.setTitulo(titulo);
		post.setImagem(file.getBytes());
		return post;
	}

	public PostDetalheDTO detalhar(Post post) {
		List<Comentario> coment = comentarioRepository.findByPost(post);
		return new PostDetalheDTO(post, coment);
	}



}