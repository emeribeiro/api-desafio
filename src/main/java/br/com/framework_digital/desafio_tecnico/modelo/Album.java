package br.com.framework_digital.desafio_tecnico.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALBUM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Imagem> imagens;
	@OneToOne
	private Usuario usuario;
	
	public Album(String titulo, List<Imagem> imagens) {
		this.titulo = titulo;
		this.imagens = imagens;
	}
	
	
}

