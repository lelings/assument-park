package com.me.assumentpark.mapper;

import com.me.assumentpark.entity.dto.EmployeeQueryDTO;
import com.me.assumentpark.entity.po.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select id,name,phone,password,salary,age,sex,create_time from employee where id = #{id}")
    Employee getById(@Param("id") Integer id);

    @Select("select id,name,phone,password,salary,age,sex,create_time from employee")
    List<Employee> list();

    List<Employee> listByCondition(EmployeeQueryDTO employeeQueryDTO);

    @Insert("insert into employee(name,phone,password,salary,age,sex,create_time) " +
            "values(#{name},#{phone},#{password},#{salary},#{age},#{sex},#{createTime})")
    void save(Employee employee);

    void update(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteById(Integer id);
}
