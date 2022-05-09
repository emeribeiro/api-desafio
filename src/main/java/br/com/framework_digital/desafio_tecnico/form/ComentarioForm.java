package br.com.framework_digital.desafio_tecnico.form;

import br.com.framework_digital.desafio_tecnico.modelo.Comentario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioForm {
	private String texto;
	private Long idPost;
	
	public Comentario converter() {
		return new Comentario(texto);
	}
}
