package br.osnircompany.desingpatternpractice.repository;

import br.osnircompany.desingpatternpractice.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
