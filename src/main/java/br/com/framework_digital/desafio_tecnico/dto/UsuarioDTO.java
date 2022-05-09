package br.com.framework_digital.desafio_tecnico.dto;

import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private String nome;
	private String username;
	private String senha;
	
	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.username = usuario.getUsername();
		this.senha = usuario.getSenha();
	}
	
	
}
