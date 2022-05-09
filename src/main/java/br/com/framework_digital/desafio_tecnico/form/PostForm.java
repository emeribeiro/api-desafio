package br.com.framework_digital.desafio_tecnico.form;

import java.io.IOException;

import br.com.framework_digital.desafio_tecnico.modelo.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
	
	private String titulo;
	private String link;
	private String texto;
	private byte[][] imagens;
	
	public Post converter() throws IOException {
		return new Post(titulo, link, texto);
	}
	
	
}
