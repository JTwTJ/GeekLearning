package service;

import lombok.Data;
import model.Student;

import java.util.List;

@Data
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }

    public void qiang() {
        System.out.println("coding fucking!!!!");
    }

}
