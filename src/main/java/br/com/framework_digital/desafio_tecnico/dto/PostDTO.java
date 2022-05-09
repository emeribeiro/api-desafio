package br.com.framework_digital.desafio_tecnico.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.framework_digital.desafio_tecnico.modelo.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	private Long id;
	private String titulo;
	private String link;
	private String texto;
	private String usuario;
	private byte[] imagem;
	
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.link = post.getLink();
		this.texto = post.getTexto();
		this.usuario = post.getUsuario() != null ? post.getUsuario().getUsername() : null;
		this.imagem = post.getImagem();
	}
	
	public static List<PostDTO> converter(List<Post> posts) {
		return posts.stream().map(PostDTO::new).collect(Collectors.toList());
	}
}
