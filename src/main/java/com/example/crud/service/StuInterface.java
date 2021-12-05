package com.example.crud.service;

import com.example.crud.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjr
 * @create 2021-12-01 13:37
 */
@Service
public interface StuInterface {
    //查询
    List<Student> QueryAll();
    //按照学号查询学生信息
    Student selectByPrimaryKey(Integer sno);
    //新增
    boolean Add(Student student);
    //删除
    boolean Del(int sno);
    //修改
    boolean Update(Student student);

}
