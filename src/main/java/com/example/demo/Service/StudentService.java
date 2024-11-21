package com.example.demo.Service;

import com.example.demo.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

   ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
       students.add(student) ;
    }

    public boolean updateStudent(String index,Student student)
    {
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId().equalsIgnoreCase(index))
            {
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String index)
    {
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId().equalsIgnoreCase(index))
            {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudent(String index)
    {
        ArrayList<Student> matchingStudent = new ArrayList<>();

        for (Student loop:students)
        {
            if (loop.getId().equalsIgnoreCase(index))
            {
                matchingStudent.add(loop);
            }
        }
        return matchingStudent;
    }



}


