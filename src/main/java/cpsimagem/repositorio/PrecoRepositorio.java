package cpsimagem.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cpsimagem.model.Preco;


@Repository
public interface PrecoRepositorio extends CrudRepository<Preco, Long> {



}
