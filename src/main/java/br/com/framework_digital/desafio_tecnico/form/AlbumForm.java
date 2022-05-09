package br.com.framework_digital.desafio_tecnico.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.framework_digital.desafio_tecnico.modelo.Album;
import br.com.framework_digital.desafio_tecnico.modelo.Imagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumForm {
	
	private String titulo;
	private MultipartFile[] imagens;

	public Album converter() throws IOException {
		List<Imagem> _imagens = new ArrayList<>();
		for (MultipartFile imagem : imagens) {
			Imagem _imagem = new Imagem();
			_imagem.setImagem(imagem.getBytes());
			_imagens.add(_imagem);
		}
		return new Album(titulo, _imagens);
	}
	
}
