package com.me.assumentpark.service.impl;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.ProjectQueryDTO;
import com.me.assumentpark.entity.po.Project;
import com.me.assumentpark.mapper.ProjectMapper;
import com.me.assumentpark.service.ProjectService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Result getById(Integer id) {
        if (id == null) {
            return Result.error(400,"非法操作");
        }
        Project project = projectMapper.getById(id);
        return Result.ok(project);
    }

    @Override
    public Result list() {
        List<Project> projects = projectMapper.list();
        return Result.ok(projects);
    }

    @Override
    public Result listByCondition(ProjectQueryDTO projectQueryDTO) {
        List<Project> projects = projectMapper.listByCondition(projectQueryDTO);
        return Result.ok(projects);
    }

    @Override
    public Result save(Project project) {
        projectMapper.save(project);
        return Result.ok();
    }

    @Override
    public Result update(Project project) {
        Integer id = project.getId();
        if (id == null) {
            return Result.error(400,"违法操作");
        }
        Project project1 = projectMapper.getById(id);
        if (project1 == null) {
            return Result.error(400,"违法操作");
        }
        projectMapper.update(project);
        return Result.ok();
    }

    @Override
    public Result deleteById(Integer id) {
        if (id == null) {
            return Result.error(400,"违法操作");
        }
        Project project = projectMapper.getById(id);
        if (project == null) {
            return Result.error(400,"违法操作");
        }
        projectMapper.deleteById(id);
        return Result.ok();
    }
}
