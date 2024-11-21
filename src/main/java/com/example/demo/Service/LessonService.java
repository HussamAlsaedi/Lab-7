package com.example.demo.Service;

import com.example.demo.Model.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LessonService {

    ArrayList<Lesson> lessons = new ArrayList<>();

    public ArrayList<Lesson> getLessons()
    {
        return lessons;
    }

    public void addLesson(Lesson lesson)
    {
        lessons.add(lesson);
    }

    public boolean updateLesson(String index, Lesson lesson)
    {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getId().equalsIgnoreCase(index))
            {
                lessons.set(i,lesson);
                return true;
            }
        }
        return false;
    }

    public boolean deleteLesson(String index)
    {
        for (int i = 0; i < lessons.size() ; i++)
        {

            if (lessons.get(i).getId().equalsIgnoreCase(index))
            {
                lessons.remove(i);
                return true;
            }

        }
        return false;
    }

    public ArrayList<Lesson> getLesson(String index)
    {
        ArrayList<Lesson> matchingLesson = new ArrayList<>();

        for(Lesson loop : lessons)
        {
            if (loop.getId().equalsIgnoreCase(index))
            {
                matchingLesson.add(loop);
            }
        }

        return matchingLesson;
    }
}
