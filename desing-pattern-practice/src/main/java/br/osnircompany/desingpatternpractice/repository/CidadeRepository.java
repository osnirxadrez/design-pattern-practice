package br.osnircompany.desingpatternpractice.repository;

import br.osnircompany.desingpatternpractice.model.Cidade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CidadeRepository extends CrudRepository<Cidade, String> {

    Iterable<Cidade> findByNameContaining(String name);
}
