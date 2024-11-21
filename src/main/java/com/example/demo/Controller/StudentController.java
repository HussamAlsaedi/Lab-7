package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAllStudent() {

        if (studentService.getAllStudents().isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("List of Student is Empty"));
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }


    @PutMapping("/update/{index}")
    public ResponseEntity updateStudent(@PathVariable String index, @RequestBody @Valid Student student, Errors errors) {

        if (errors.hasErrors()) {

            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }

        boolean isUpdated = studentService.updateStudent(index,student);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("student is updated successfully"));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("student not found"));
        }
    }

    @DeleteMapping("/delete/{index}")
     public ResponseEntity deleteStudent(@PathVariable String index)
     {
         if (studentService.deleteStudent(index)) {
             return ResponseEntity.ok(new ApiResponse("Student deleted successfully"));
         }
         return ResponseEntity.status(404).body(new ApiResponse("Student not found"));

     }

     @GetMapping("/findStudent/{index}")
     public ResponseEntity findStudent(@PathVariable String index)
     {
         if (studentService.getStudent(index).isEmpty())
         {
             return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
         }
        return ResponseEntity.ok(studentService.getStudent(index));
     }
}
