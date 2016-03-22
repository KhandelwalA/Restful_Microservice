package com.khandelwal.domainmodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*TO remember: This class generated using http://timboudreau.com/blog/json/read*/
public final class OpenWeather {
    public final City city;
    public final String cod;
    public final double message;
    public final long cnt;
    public final List list[];

    @JsonCreator
    public OpenWeather(@JsonProperty("city") City city, @JsonProperty("cod") String cod, @JsonProperty("message") double message, @JsonProperty("cnt") long cnt, @JsonProperty("list") List[] list){
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public static final class City {
        public final long id;
        public final String name;
        public final Coord coord;
        public final String country;
        public final long population;

        @JsonCreator
        public City(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("coord") Coord coord, @JsonProperty("country") String country, @JsonProperty("population") long population){
            this.id = id;
            this.name = name;
            this.coord = coord;
            this.country = country;
            this.population = population;
        }

        public static final class Coord {
            public final double lon;
            public final double lat;
    
            @JsonCreator
            public Coord(@JsonProperty("lon") double lon, @JsonProperty("lat") double lat){
                this.lon = lon;
                this.lat = lat;
            }
        }
    }

    public static final class List {
        public final long dt;
        public final Temp temp;
        public final double pressure;
        public final long humidity;
        public final Weather weather[];
        public final double speed;
        public final long deg;
        public final long clouds;
        public final double rain;

        @JsonCreator
        public List(@JsonProperty("dt") long dt, @JsonProperty("temp") Temp temp, @JsonProperty("pressure") double pressure, @JsonProperty("humidity") long humidity, @JsonProperty("weather") Weather[] weather, @JsonProperty("speed") double speed, @JsonProperty("deg") long deg, @JsonProperty("clouds") long clouds, @JsonProperty("rain") double rain){
            this.dt = dt;
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.weather = weather;
            this.speed = speed;
            this.deg = deg;
            this.clouds = clouds;
            this.rain = rain;
        }

        public static final class Temp {
            public final double day;
            public final double min;
            public final double max;
            public final double night;
            public final double eve;
            public final double morn;
    
            @JsonCreator
            public Temp(@JsonProperty("day") double day, @JsonProperty("min") double min, @JsonProperty("max") double max, @JsonProperty("night") double night, @JsonProperty("eve") double eve, @JsonProperty("morn") double morn){
                this.day = day;
                this.min = min;
                this.max = max;
                this.night = night;
                this.eve = eve;
                this.morn = morn;
            }
        }

        public static final class Weather {
            public final long id;
            public final String main;
            public final String description;
            public final String icon;
    
            @JsonCreator
            public Weather(@JsonProperty("id") long id, @JsonProperty("main") String main, @JsonProperty("description") String description, @JsonProperty("icon") String icon){
                this.id = id;
                this.main = main;
                this.description = description;
                this.icon = icon;
            }
        }
    }
}