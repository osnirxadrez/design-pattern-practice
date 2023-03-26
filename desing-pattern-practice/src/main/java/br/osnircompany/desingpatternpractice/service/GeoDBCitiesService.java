package br.osnircompany.desingpatternpractice.service;

import br.osnircompany.desingpatternpractice.model.ResponseCidade;
import br.osnircompany.desingpatternpractice.model.ResponseGeoDBCities;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;


@FeignClient(name = "geodbcities", url = "https://wft-geo-db.p.rapidapi.com/")
public interface GeoDBCitiesService {

    @GetMapping("v1/geo/cities?namePrefix={nome}&languageCode=pt")
    ResponseGeoDBCities getCidadesByNome(@RequestHeader Map<String, Object> headers, @PathVariable("nome") String nome);

    @GetMapping("v1/geo/cities/{id}")
    ResponseCidade getCidadesById(@RequestHeader Map<String, Object> headers, @PathVariable("id") Integer id);

}
