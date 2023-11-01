package com.it.pojo.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.pojo.ManagerBatch;
import com.it.pojo.QuarantineRegistration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QuarantineRegistrationExt extends QuarantineRegistration {
    @JsonProperty("managerBatch")
    private ManagerBatch managerBatch;
}
