package br.osnircompany.desingpatternpractice.model;

import java.util.List;

public class ResponseGeoDBCities {
    List<Cidade> data;

    public List<Cidade> getData() {
        return data;
    }

    public void setData(List<Cidade> data) {
        this.data = data;
    }
}
