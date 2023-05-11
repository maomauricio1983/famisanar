package com.maoamuricio.app.famisanar.models.entities;


import jakarta.persistence.*;

@Entity
public class Student extends Person{


    private int StudentNumber;



    private int AverageMark;




    public Integer getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        StudentNumber = studentNumber;
    }

    public int getAverageMark() {
        return AverageMark;
    }

    public void setAverageMark(int averageMark) {
        AverageMark = averageMark;
    }
}
