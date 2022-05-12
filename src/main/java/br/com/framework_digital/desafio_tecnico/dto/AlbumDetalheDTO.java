package br.com.framework_digital.desafio_tecnico.dto;

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
public class AlbumDetalheDTO {
	
	private Long id;
	private String titulo;
	private String usuario;
	private List<Imagem> imagens;
	private MultipartFile[] files;
	
	public AlbumDetalheDTO(Album album) {
		this.id = album.getId();
		this.titulo = album.getTitulo();
		this.usuario = album.getUsuario() != null ? album.getUsuario().getUsername() : null;
		this.imagens = album.getImagens();
	}
	
	

}
