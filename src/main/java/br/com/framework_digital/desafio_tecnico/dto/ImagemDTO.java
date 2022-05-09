package br.com.framework_digital.desafio_tecnico.dto;

import br.com.framework_digital.desafio_tecnico.modelo.Imagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {
	
	private Long id;
	private byte[] imagem;
	
	public ImagemDTO(Imagem imagem) {
		this.id = imagem.getId();
		this.imagem = imagem.getImagem();
	}

}
