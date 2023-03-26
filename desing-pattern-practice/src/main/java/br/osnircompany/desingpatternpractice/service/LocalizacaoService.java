package br.osnircompany.desingpatternpractice.service;

import br.osnircompany.desingpatternpractice.model.Cidade;

import java.util.List;

public interface LocalizacaoService {

    Iterable<Cidade> getCidadeByNome (String nome);

    Cidade getCidadeById (Integer id);
}
