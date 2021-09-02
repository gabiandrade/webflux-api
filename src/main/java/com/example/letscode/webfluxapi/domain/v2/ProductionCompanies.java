package com.example.letscode.webfluxapi.domain.v2;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductionCompanies {

    private Integer id;

    private String name;

    @SerializedName("logo_path")
    private String logoPath;

    @SerializedName("original_country")
    private String originalCountry;
}
