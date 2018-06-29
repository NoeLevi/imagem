package cpsimagem.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cpsimagem.model.Preco;
import cpsimagem.model.Servico;


@Repository
public interface ServicoRepositorio extends CrudRepository<Servico, Long> {



}
