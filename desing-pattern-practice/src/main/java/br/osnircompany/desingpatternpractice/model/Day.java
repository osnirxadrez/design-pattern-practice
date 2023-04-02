package br.osnircompany.desingpatternpractice.model;

public class Day {
    String maxtemp_c;
    String mintemp_c;
    String avgtemp_c;
    String maxwind_kph;
    String totalprecip_mm;
    String daily_will_it_rain;
    String daily_chance_of_rain;

    public String getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(String maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public String getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(String mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public String getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(String avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public String getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(String maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public String getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(String totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public String getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public void setDaily_will_it_rain(String daily_will_it_rain) {
        this.daily_will_it_rain = daily_will_it_rain;
    }

    public String getDaily_chance_of_rain() {
        return daily_chance_of_rain;
    }

    public void setDaily_chance_of_rain(String daily_chance_of_rain) {
        this.daily_chance_of_rain = daily_chance_of_rain;
    }
}
