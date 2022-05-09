package br.com.framework_digital.desafio_tecnico.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.framework_digital.desafio_tecnico.modelo.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
	
	private Long id;
	private String titulo;
	private List<ImagemDTO> imagens = new ArrayList<>();
	private String usuario;
	
	public AlbumDTO(Album album) {
		this.id = album.getId();
		this.titulo = album.getTitulo();
		this.usuario = album.getUsuario() != null ? album.getUsuario().getUsername() : null;
		this.imagens.addAll(album.getImagens().stream().map(ImagemDTO::new).collect(Collectors.toList()));
	}

	public static List<AlbumDTO> converter(List<Album> albuns) {
		return albuns.stream().map(AlbumDTO::new).collect(Collectors.toList());
	}
 	
}
