package com.it.pojo.ext;

import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DiseaseRecordExt extends DiseaseRecord {
    @JsonProperty("disease")
    private ManagerDisease disease;
}
