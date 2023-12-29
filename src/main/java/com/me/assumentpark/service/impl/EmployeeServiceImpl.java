package com.me.assumentpark.service.impl;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.EmployeeDTO;
import com.me.assumentpark.entity.dto.EmployeeQueryDTO;
import com.me.assumentpark.entity.po.Employee;
import com.me.assumentpark.mapper.EmployeeMapper;
import com.me.assumentpark.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 根据id获取游客
     * @param id
     * @return
     */
    @Override
    public Result getById(Integer id) {
        if (id == null) {
            return Result.error(404,"员工不存在");
        }

        Employee employee = employeeMapper.getById(id);
        if (employee == null) {
            return Result.error(404,"员工不存在");
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>();

        return Result.ok(employee);
    }

    /**
     * 列出所有游客
     * @return
     */
    @Override
    public Result list() {
        List<Employee> employees = employeeMapper.list();
        return Result.ok(employees);
    }

    /**
     * 根据复杂条件列出游客
     * @param employeeQueryDTO
     * @return
     */
    @Override
    public Result listByCondition(EmployeeQueryDTO employeeQueryDTO) {
        List<Employee> employees = employeeMapper.listByCondition(employeeQueryDTO);
        return Result.ok(employees);
    }

    /**
     * 新增游客
     * @param employeeDTO
     * @return
     */
    @Override
    public Result save(EmployeeDTO employeeDTO) {
        if (employeeDTO.getName() == null || employeeDTO.getName().equals("")) {
            return Result.error(400,"名字不能为空");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        String password = DigestUtils.md5DigestAsHex(employeeDTO.getPassword().getBytes());
        employee.setPassword(password);
        employee.setCreateTime(LocalDateTime.now());
        employeeMapper.save(employee);
        return Result.ok();
    }

    @Override
    public Result update(EmployeeDTO employeeDTO) {
        Integer id = employeeDTO.getId();
        if (id == null) {
            return Result.error(400,"违法操作");
        }
        Employee employee1 = employeeMapper.getById(id);
        if (employee1 == null) {
            return Result.error(400,"违法操作");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        if (employeeDTO.getPassword() != null) {
            String password = DigestUtils.md5DigestAsHex(employeeDTO.getPassword().getBytes());
            employee.setPassword(password);
        }
        employeeMapper.update(employee);
        return Result.ok();
    }

    @Override
    public Result deleteById(Integer id) {
        if (id == null) {
            return Result.error(400,"违法操作");
        }
        Employee employee = employeeMapper.getById(id);
        if (employee == null) {
            return Result.error(400,"违法操作");
        }
        employeeMapper.deleteById(id);
        return Result.ok();
    }


}
