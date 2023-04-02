package br.osnircompany.desingpatternpractice.controller;

import br.osnircompany.desingpatternpractice.model.Cidade;
import br.osnircompany.desingpatternpractice.model.Forecast;
import br.osnircompany.desingpatternpractice.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GeoLocalizacaoRestController {
    @Autowired
    LocalizacaoService localizacaoService;

    @GetMapping("cidades/nome/{nome}")
    public ResponseEntity<Iterable<Cidade>> getCidadePorNome(@PathVariable String nome) {
        return ResponseEntity.ok(localizacaoService.getCidadeByNome(nome));
    }

    @GetMapping("cidades/id/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable Integer id) {
        return ResponseEntity.ok(localizacaoService.getCidadeById(id));
    }

    @GetMapping("cidades/previsao/id/{id}")
    public ResponseEntity<Forecast> getPrevisaoDoTempoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(localizacaoService.getPrevisaoPorCidade(id));
    }
}
