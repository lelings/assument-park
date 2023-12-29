package com.me.assumentpark.service;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.EmployeeQueryDTO;
import com.me.assumentpark.entity.dto.EmployeeDTO;

public interface EmployeeService {

    Result getById(Integer id);

    Result list();

    Result listByCondition(EmployeeQueryDTO employeeQueryDTO);

    Result save(EmployeeDTO employeeDTO);

    Result update(EmployeeDTO employeeDTO);

    Result deleteById(Integer id);
}
