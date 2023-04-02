package br.osnircompany.desingpatternpractice.model;

import java.util.List;

public class Forecast {
    List<ForecastDay> forecastday;

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }
}
