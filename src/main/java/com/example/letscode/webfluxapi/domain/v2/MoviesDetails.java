package com.example.letscode.webfluxapi.domain.v2;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
public class MoviesDetails {


    private Integer id;
    private boolean adult;
    private String backdropPath;
    private Integer budget;
    private List<Genres> genres;
    private String homepage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;

    @SerializedName("production_companies")
    private List<ProductionCompanies> productionCompanies;

    @SerializedName("production_countries")
    private List<ProductionCountries> productionCountries;

    private String releaseDate;
    private Integer revenue;
    private Integer runtime;

    @SerializedName("spoken_languages")
    private List<SpokenLanguages> spokenLanguages;

    private String status;
    private String tagline;
    private String title;
    private boolean video;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("vote_count")
    private Double voteCount;
}
