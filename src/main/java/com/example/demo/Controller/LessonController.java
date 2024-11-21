package com.example.demo.Controller;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Model.Lesson;
import com.example.demo.Service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/lesson")
@RequiredArgsConstructor
public class LessonController {

  private final LessonService lessonService;


  @GetMapping("/get")
  public ResponseEntity getAllLessons()
  {
      if(lessonService.getLessons().isEmpty())
      {
          return ResponseEntity.status(400).body(new ApiResponse("List of Lesson is Empty"));
      }
      return ResponseEntity.ok(lessonService.getLessons());
  }

  @PostMapping("/add")
  public ResponseEntity addLesson(@RequestBody @Valid Lesson lesson, Errors errors)
  {
      if (errors.hasErrors())
      {return  ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());}
      lessonService.addLesson(lesson);
      return ResponseEntity.status(200).body(new ApiResponse("Lesson added successfully"));
  }

  @PutMapping("/update/{index}")
  public ResponseEntity updateLesson(@PathVariable String index , @RequestBody @Valid Lesson lesson, Errors errors)
  {
      if (errors.hasErrors())
      {return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());}

      lessonService.updateLesson(index,lesson);
      return ResponseEntity.status(200).body(new ApiResponse("Lesson is updated successfully"));
  }

  @DeleteMapping("/delete/{index}")
  public ResponseEntity deleteLesson(@PathVariable String index)
  {

     if (lessonService.deleteLesson(index)) {
         return ResponseEntity.status(200).body(new ApiResponse("Lesson is Deleted successfully"));
     }
      return ResponseEntity.status(404).body(new ApiResponse("Lesson not found"));
  }

    @GetMapping("/findLesson/{index}")
    public ResponseEntity findLesson(@PathVariable String index)
    {
        if (lessonService.getLesson(index).isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("Lesson not found"));
        }
        return ResponseEntity.ok(lessonService.getLesson(index));
    }


}
