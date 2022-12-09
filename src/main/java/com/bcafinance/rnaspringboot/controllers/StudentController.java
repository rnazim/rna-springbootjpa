package com.bcafinance.rnaspringboot.controllers;

import com.bcafinance.rnaspringboot.dto.StudentDTO;
import com.bcafinance.rnaspringboot.handler.ResourceNotFoundException;
import com.bcafinance.rnaspringboot.handler.ResponseHandler;
import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.services.StudentService;
import com.bcafinance.rnaspringboot.utils.ConstantMessage;

import com.bcafinance.rnaspringboot.utils.CsvReader;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class StudentController {

    @Getter
    private StudentService studentService;
    @Autowired
    private ModelMapper modelMapper;

    private List<Student> lsStudent = new ArrayList<Student>();

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/v1/student/upl/bat/11")
    public ResponseEntity<Object>
    uploadStudent(@Valid @RequestParam("demoFile") MultipartFile multipartFile) throws Exception {
        try {
            if (CsvReader.isCsv(multipartFile)) {
                studentService.saveBulkStudent(multipartFile);
            } else {
                throw new ResourceNotFoundException(ConstantMessage.ERROR_NOT_CSV_FILE + " -- " + multipartFile.getOriginalFilename());
            }
        } catch (Exception e) {
            throw new Exception(ConstantMessage.ERROR_UPLOAD_CSV + multipartFile.getOriginalFilename());
        }
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE,
                HttpStatus.CREATED, null, null, null);
    }

    @GetMapping("/v1/student/datas/all/dto/9")
    public ResponseEntity<Object> findAllStudentDTO() throws Exception {

        List<Student> lsStudent = studentService.findAllStudent();

        if (lsStudent.size() != 0) {
            List<StudentDTO> lsSttudentDTO = modelMapper.map(lsStudent, new TypeToken<List<StudentDTO>>() {
            }.getType());

            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsSttudentDTO, null, null);
        }
        throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
    }

    @GetMapping("/v1/student/search/dto/{size}/{page}")
    public ResponseEntity<Object> pageFindStudentByNameDTO(@RequestParam String name,
                                                           @PathVariable("size") int size,
                                                           @PathVariable("page") int page) throws Exception {


        Pageable pageable = PageRequest.of(page, size);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, studentService.pagingFindStudentByName(name, pageable), null, null);
    }

    @GetMapping("/v1/student/search/dto/{size}/{page}/{sort}")
    public ResponseEntity<Object> pageSortByNameDTO(@RequestParam String name,
                                                    @PathVariable("size") int size,
                                                    @PathVariable("page") int page,
                                                    @PathVariable("sort") String sortz) throws Exception {

        Pageable pageable;
        if (sortz.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, size, Sort.by("id").descending());
        } else {
            pageable = PageRequest.of(page, size, Sort.by("id"));//default asc
        }
        Page<Student> m = studentService.pagingFindStudentByName(name, pageable);
        List<Student> ls = m.getContent();
        List<Student> lsDto = modelMapper.map(ls, new TypeToken<List<StudentDTO>>() {
        }.getType());

        Map<String, Object> mapz = new HashMap<String, Object>();
        mapz.put("content", lsDto);
        mapz.put("currentPage", m.getNumber());
        mapz.put("totalItems", m.getTotalElements());
        mapz.put("totalPages", m.getTotalPages());
        mapz.put("sort", m.getSort());
        mapz.put("numberOfElements", m.getNumberOfElements());


        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, mapz, null, null);
    }

}

