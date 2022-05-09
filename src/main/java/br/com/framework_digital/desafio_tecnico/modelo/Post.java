package br.com.framework_digital.desafio_tecnico.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "POST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String link;
	@Column(columnDefinition = "text", length = 10485760)
	private String texto;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<>();
	private byte[] imagem;
	@OneToOne
	private Usuario usuario;
	
	public Post(String titulo, String link, String texto) {
		this.titulo = titulo;
		this.link = link;
		this.texto = texto;
	}
	
	

}
