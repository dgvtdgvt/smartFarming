package com.it.pojo.ext;

import com.it.pojo.ManagerAnimal;
import com.it.pojo.ManagerBatch;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerAnimalExt extends ManagerAnimal {
    @JsonProperty("managerHurdles")
    private String managerHurdles;
    @JsonProperty("managerFenceHouse")
    private String managerFenceHouse;
    @JsonProperty("aBackup3")
    private String url;
    @JsonProperty("managerBatch")
    private ManagerBatch managerBatch;
}
