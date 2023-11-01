package com.it.dao.ext;

import com.it.pojo.ext.QuarantineRegistrationExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuarantineRegistrationExtMapper {
    List<QuarantineRegistrationExt> queryAllRegistration(String grMechanism, String bQualified);
}
