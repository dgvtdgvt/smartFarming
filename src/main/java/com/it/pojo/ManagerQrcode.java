package com.it.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ManagerQrcode {
    @JsonProperty("qId")
    private Integer qId;
    @JsonProperty("qAnimalId")
    private String qAnimalId;
    @JsonProperty("qImageUrl")
    private String qImageUrl;
}