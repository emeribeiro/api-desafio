package br.com.framework_digital.desafio_tecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework_digital.desafio_tecnico.dto.TokenDTO;
import br.com.framework_digital.desafio_tecnico.form.LoginForm;
import br.com.framework_digital.desafio_tecnico.form.UsuarioForm;
import br.com.framework_digital.desafio_tecnico.service.AutenticacaoService;
import br.com.framework_digital.desafio_tecnico.service.TokenService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AutenticacaoService autenticacaoService;

	@PostMapping("/login")
	public ResponseEntity<TokenDTO> autenticar(@RequestBody LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer", dadosLogin.getName()));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody UsuarioForm form) {
		autenticacaoService.registrar(form);
		return ResponseEntity.ok().build();
	}
}
