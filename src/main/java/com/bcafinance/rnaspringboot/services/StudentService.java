package com.bcafinance.rnaspringboot.services;

import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.repos.StudentRepo;

import com.bcafinance.rnaspringboot.utils.CsvReader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Getter
    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Student> saveBulkStudent(MultipartFile multipartFile) throws Exception
    {
        try{
            List<Student> lsStudent = CsvReader.csvStudentData(multipartFile.getInputStream());
            return studentRepo.saveAll(lsStudent);
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public List<Student> findAllStudent()
    {
        return (List<Student>) studentRepo.findAll();
    }

    public Page<Student> pagingFindStudentByName(String name, Pageable pageable)
    {
        return studentRepo.findByFullNameIsContaining(name,pageable);
    }
}
