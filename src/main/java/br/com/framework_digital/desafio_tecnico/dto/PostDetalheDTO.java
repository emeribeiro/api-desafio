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
public class PostDetalheDTO {
	private Long id;
	private String titulo;
	private String link;
	private String texto;
	private byte[] imagem;
	private String usuario;
	private List<ComentarioDTO> comentarios;
	
	public PostDetalheDTO(Post post) {
		super();
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.link = post.getLink();
		this.texto = post.getTexto();
		this.imagem = post.getImagem();
		this.usuario = post.getUsuario().getUsername();
		this.comentarios.addAll(post.getComentarios().stream().map(ComentarioDTO::new).collect(Collectors.toList()));
	}
}
