package com.example.crud.service;

import com.example.crud.entity.Student;
import com.example.crud.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjr
 * @create 2021-12-01 13:42
 */
@Service
public class StuImpl implements StuInterface {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> QueryAll() {
        List<Student> students=studentMapper.QueryAll();
        return students;
    }

    @Override
    public Student selectByPrimaryKey(Integer sno) {
       Student student= studentMapper.selectByPrimaryKey(sno);
       return student;
    }

    @Override
    public boolean Add(Student student) {
        int i=studentMapper.insert(student);
        if (i>0)
            return true;
        else
        return false;
    }

    @Override
    public boolean Del(int sno) {
        int i=studentMapper.deleteByPrimaryKey(sno);
        if (i>0)
            return true;
        else
        return false;
    }

    @Override
    public boolean Update(Student student) {
        int i=studentMapper.updateByPrimaryKey(student);
        if (i>0)
            return true;
        else
            return false;
    }
}
