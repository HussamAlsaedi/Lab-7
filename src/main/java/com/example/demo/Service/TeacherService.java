package com.example.demo.Service;

import com.example.demo.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAllTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher) ;
    }

    public boolean updateTeacher(String index,Teacher teacher)
    {
       for (int i = 0; i < teachers.size(); i++) {

            if (teachers.get(i).getId().equalsIgnoreCase(index))
            {
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String index)
    {
        for (int i = 0; i < teachers.size(); i++) {

            if (teachers.get(i).getId().equalsIgnoreCase(index))
            {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Teacher> getTeacher(String index)
    {
        ArrayList<Teacher> matchingTeacher = new ArrayList<>();

        for (Teacher loop: teachers)
        {
            if (loop.getId().equalsIgnoreCase(index))
            {
                matchingTeacher.add(loop);
            }
        }
        return matchingTeacher;
    }

}
