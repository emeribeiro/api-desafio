package br.com.framework_digital.desafio_tecnico.dto;

import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {
	private Long id;
	private Long idPost;
	private String texto;
	private String usuario;
	
	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.idPost = comentario.getPost().getId();
		this.texto = comentario.getTexto();
		this.usuario = comentario.getUsuario() != null ? comentario.getUsuario().getUsername() : null;
	}
	
	
}
