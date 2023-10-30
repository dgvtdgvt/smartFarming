package com.it.pojo.ext;

import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ManagerHurdles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerFenceHouseExt extends ManagerFenceHouse {
    @JsonProperty("mhs")
    private List<ManagerHurdles> mhs;
}
