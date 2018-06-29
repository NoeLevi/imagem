package cpsimagem.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cpsimagem.model.Usuario;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {



}
