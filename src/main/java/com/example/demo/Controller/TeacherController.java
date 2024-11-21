package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;

import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher()
    {
        if (teacherService.getAllTeachers().isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("List of Teacher is Empty"));
        }
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }


    @PutMapping("/update/{index}")
    public ResponseEntity updateTeacher(@PathVariable String index, @RequestBody @Valid Teacher teacher, Errors errors) {

        if (errors.hasErrors()) {

            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }

        boolean isUpdated = teacherService.updateTeacher(index,teacher);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Teacher is updated successfully"));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("Teacher not found"));
        }
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteTeacher(@PathVariable String index)
    {
        if (teacherService.deleteTeacher(index)) {
            return ResponseEntity.ok(new ApiResponse("Teacher deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Teacher not found"));

    }

    @GetMapping("/findTeacher/{index}")
    public ResponseEntity findTeacher(@PathVariable String index)
    {
        if (teacherService.getTeacher(index).isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("Teacher not found"));
        }
        return ResponseEntity.ok(teacherService.getTeacher(index));
    }
}
