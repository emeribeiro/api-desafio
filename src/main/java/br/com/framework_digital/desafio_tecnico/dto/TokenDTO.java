package br.com.framework_digital.desafio_tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
	
	private String token;
	private String tipo;
	private String username;

}
