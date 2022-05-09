package br.com.framework_digital.desafio_tecnico.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.framework_digital.desafio_tecnico.config.security.UsuarioLogado;
import br.com.framework_digital.desafio_tecnico.dto.AlbumDTO;
import br.com.framework_digital.desafio_tecnico.modelo.Album;
import br.com.framework_digital.desafio_tecnico.modelo.Imagem;
import br.com.framework_digital.desafio_tecnico.modelo.Usuario;
import br.com.framework_digital.desafio_tecnico.repository.AlbumRepository;
import br.com.framework_digital.desafio_tecnico.repository.UsuarioRepository;


@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Album getAlbumForm(MultipartFile[] files, String titulo) throws IOException {
		Album album = new Album();
		album.setTitulo(titulo);
		List<Imagem> imagens = new ArrayList<>();
		if(files != null) {
			for (MultipartFile file : files) {
				Imagem imagem = new Imagem();
				imagem.setImagem(file.getBytes());
				imagens.add(imagem);
			}
		}
		album.setImagens(imagens);
		album.setUsuario(usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get());
		return album;
	}

	public void criarAlbum(Album album) {
		albumRepository.save(album);
	}

	public List<AlbumDTO> listarAlbuns() {
		List<Album> albuns = albumRepository.findAll();
		return AlbumDTO.converter(albuns);
	}

	public Optional<Album> buscarPorId(Long id) {
		return albumRepository.findById(id);
	}

	public void deletarPorId(Long id, Optional<Album> album) throws Exception {
		Usuario usuario = usuarioRepository.findByUsername(UsuarioLogado.usuarioLogado()).get();
		if (album.get().getUsuario().getId().equals(usuario.getId())) {
			albumRepository.deleteById(id);
		} else {
			 throw new Exception();
		}
	}
	
}
