package com.it.pojo.ext;

import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ManagerHurdles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerHurdlesExt extends ManagerHurdles {
    @JsonProperty("managerFenceHouse")
    private ManagerFenceHouse managerFenceHouse;
}
