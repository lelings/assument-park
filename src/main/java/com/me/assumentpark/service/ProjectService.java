package com.me.assumentpark.service;

import com.me.assumentpark.common.Result;
import com.me.assumentpark.entity.dto.ProjectQueryDTO;
import com.me.assumentpark.entity.po.Project;

public interface ProjectService {

    Result getById(Integer id);

    Result list();

    Result listByCondition(ProjectQueryDTO projectQueryDTO);

    Result save(Project project);

    Result update(Project project);

    Result deleteById(Integer id);
}
