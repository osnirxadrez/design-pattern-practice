package br.osnircompany.desingpatternpractice.service.impl;

import br.osnircompany.desingpatternpractice.model.Cidade;
import br.osnircompany.desingpatternpractice.repository.CidadeRepository;
import br.osnircompany.desingpatternpractice.service.GeoDBCitiesService;
import br.osnircompany.desingpatternpractice.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {
    @Autowired
    GeoDBCitiesService geoDBCitiesService;
    @Autowired
    CidadeRepository cidadeRepository;

    Map<String,Object> headerMap = new HashMap<>();

    @Override
    public Iterable<Cidade> getCidadeByNome (String nome) {
        Iterable<Cidade> cidades = cidadeRepository.findByNameContaining(nome);
        if (cidades != null) {
            return cidades;
        }
        headerMap.put("X-RapidAPI-Key", "a796ced7a8msh75a87dbec7c30fdp1e60cejsn71b7880a8eaf");
        headerMap.put("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");



        return cidadeRepository.saveAll(geoDBCitiesService.getCidadesByNome(headerMap, nome).getData());
    }

    @Override
    public Cidade getCidadeById(Integer id) {
        headerMap.put("X-RapidAPI-Key", "a796ced7a8msh75a87dbec7c30fdp1e60cejsn71b7880a8eaf");
        headerMap.put("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
        return geoDBCitiesService.getCidadesById(headerMap, id).getData();
    }
}
