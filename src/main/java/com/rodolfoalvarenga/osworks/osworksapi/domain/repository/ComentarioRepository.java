package com.rodolfoalvarenga.osworks.osworksapi.domain.repository;

import com.rodolfoalvarenga.osworks.osworksapi.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
