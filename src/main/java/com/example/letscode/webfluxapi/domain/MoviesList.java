package com.example.letscode.webfluxapi.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MoviesList {
    @SerializedName("results")
    public List<Movie> moviesList;

    public String getItemCount(){
        return "Quantidade de filmes encontrados: " + this.moviesList.size();
    }
}
