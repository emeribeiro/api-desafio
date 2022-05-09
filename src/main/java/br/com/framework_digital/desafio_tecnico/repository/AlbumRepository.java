package br.com.framework_digital.desafio_tecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.framework_digital.desafio_tecnico.modelo.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
