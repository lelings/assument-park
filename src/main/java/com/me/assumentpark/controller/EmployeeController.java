package com.me.assumentpark.controller;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.EmployeeQueryDTO;
import com.me.assumentpark.entity.dto.EmployeeDTO;
import com.me.assumentpark.service.EmployeeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE,RequestMethod.PUT, RequestMethod.OPTIONS })
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @GetMapping("/list")
    public Result list() {
        return employeeService.list();
    }

    @PostMapping("/list")
    public Result listByCondition(@RequestBody EmployeeQueryDTO employeeQueryDTO) {
        return employeeService.listByCondition(employeeQueryDTO);
    }

    @PostMapping
    public Result addVisitor(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @PutMapping
    public Result updateVisitor(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public Result deleteVisitor(@PathVariable("id") Integer id) {
        System.out.println(id);
        return employeeService.deleteById(id);
    }
}
