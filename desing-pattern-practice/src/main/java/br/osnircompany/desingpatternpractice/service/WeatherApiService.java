package br.osnircompany.desingpatternpractice.service;

import br.osnircompany.desingpatternpractice.model.ResponseForecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "weatherapi", url = "https://weatherapi-com.p.rapidapi.com/")
public interface WeatherApiService {

    @GetMapping("forecast.json?q={localizacao}&days=3")
    ResponseForecast getPrevisaoPorLocalizacao(@RequestHeader Map<String, Object> headers, @PathVariable("localizacao") String localizacao);
}
