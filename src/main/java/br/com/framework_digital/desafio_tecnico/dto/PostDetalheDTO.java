package br.com.framework_digital.desafio_tecnico.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
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
	private List<ComentarioDTO> comentarios = new ArrayList<>();
	
	public PostDetalheDTO(Post post, List<Comentario> coment) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.link = post.getLink();
		this.texto = post.getTexto();
		this.imagem = post.getImagem();
		this.usuario = post.getUsuario().getUsername();
		this.comentarios = coment.stream().map(comentario -> {
			ComentarioDTO dto = new ComentarioDTO();
				dto.setTexto(comentario.getTexto());
				dto.setId(comentario.getId());
				dto.setUsuario(comentario.getUsuario().getUsername());
				return dto;
			}).collect(Collectors.toList());
	}
	
}
