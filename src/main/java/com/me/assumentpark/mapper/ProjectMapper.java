package com.me.assumentpark.mapper;

import com.me.assumentpark.entity.dto.ProjectQueryDTO;
import com.me.assumentpark.entity.po.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select id,name,price,begin_time,end_time,max_size,status,description from project " +
            "where id = #{id}")
    Project getById(Integer id);

    @Select("select id,name,price,begin_time,end_time,max_size,status,description from project")
    List<Project> list();

    List<Project> listByCondition(ProjectQueryDTO projectQueryDTO);

    @Insert("insert into project(name,price,begin_time,end_time,max_size,status,description) " +
            "values(#{name},#{price},#{beginTime},#{endTime},#{maxSize},#{status},#{description})")
    void save(Project project);

    void update(Project project);

    @Delete("delete from project where id = #{id}")
    void deleteById(Integer id);
}
