package br.osnircompany.desingpatternpractice.repository;

import br.osnircompany.desingpatternpractice.model.Cidade;
import org.springframework.data.repository.CrudRepository;


public interface CidadeRepository extends CrudRepository<Cidade, String> {

    Iterable<Cidade> findByNameContaining(String name);
}
