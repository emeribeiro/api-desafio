package br.com.framework_digital.desafio_tecnico.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm {
	
	private String nome;
	private String username;
	private String senha;
	
	public Usuario converter() {
		return new Usuario(nome, username, new BCryptPasswordEncoder().encode(senha));
	}
}
