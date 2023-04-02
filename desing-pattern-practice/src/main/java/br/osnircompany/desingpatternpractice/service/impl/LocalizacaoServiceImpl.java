package br.osnircompany.desingpatternpractice.service.impl;

import br.osnircompany.desingpatternpractice.model.Cidade;
import br.osnircompany.desingpatternpractice.model.Forecast;
import br.osnircompany.desingpatternpractice.repository.CidadeRepository;
import br.osnircompany.desingpatternpractice.service.GeoDBCitiesService;
import br.osnircompany.desingpatternpractice.service.LocalizacaoService;
import br.osnircompany.desingpatternpractice.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {
    @Autowired
    GeoDBCitiesService geoDBCitiesService;
    @Autowired
    CidadeRepository cidadeRepository;
    @Autowired
    WeatherApiService weatherApiService;

    @Override
    public Iterable<Cidade> getCidadeByNome (String nome) {
        Iterable<Cidade> cidades = cidadeRepository.findByNameContaining(nome);
        if (cidades != null && cidades.iterator().hasNext()) {
            return cidades;
        }
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("X-RapidAPI-Key", "a796ced7a8msh75a87dbec7c30fdp1e60cejsn71b7880a8eaf");
        headerMap.put("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");

        return cidadeRepository.saveAll(geoDBCitiesService.getCidadesByNome(headerMap, nome).getData());
    }

    @Override
    public Cidade getCidadeById(Integer id) {
        Cidade cidade = cidadeRepository.findById(id.toString()).orElse(null);
        if (cidade != null) {
            return cidade;
        }

        Map<String,Object> headerMap = new HashMap<>();

        headerMap.put("X-RapidAPI-Key", "a796ced7a8msh75a87dbec7c30fdp1e60cejsn71b7880a8eaf");
        headerMap.put("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
        return cidadeRepository.save(geoDBCitiesService.getCidadesById(headerMap, id).getData());
    }

    public Forecast getPrevisaoPorCidade (Integer id) {
        Cidade cidade = getCidadeById(id);
        Map<String,Object> headerMap = new HashMap<>();

        headerMap.put("X-RapidAPI-Key", "a796ced7a8msh75a87dbec7c30fdp1e60cejsn71b7880a8eaf");
        headerMap.put("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");

        return weatherApiService.getPrevisaoPorLocalizacao(headerMap, cidade.getLatitude()+","+cidade.getLongitude()).getForecast();
    }
}
