package com.me.assumentpark.controller;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.ProjectQueryDTO;
import com.me.assumentpark.entity.po.Project;
import com.me.assumentpark.service.ProjectService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE,RequestMethod.PUT, RequestMethod.OPTIONS })
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Result getProjectById(@PathVariable("id") Integer id) {
        return projectService.getById(id);
    }

    @GetMapping("/list")
    public Result listProject() {
        return projectService.list();
    }

    @PostMapping("/list")
    public Result listProjectByCondition(@RequestBody ProjectQueryDTO projectQueryDTO) {
        return projectService.listByCondition(projectQueryDTO);
    }

    @PostMapping
    public Result addProject(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping
    public Result updateProject(@RequestBody Project project) {
        return projectService.update(project);
    }

    @DeleteMapping("/{id}")
    public Result deleteProject(@PathVariable Integer id) {
        return projectService.deleteById(id);
    }
}
