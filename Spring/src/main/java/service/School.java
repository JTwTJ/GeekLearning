package service;

import aop.ISchool;
import lombok.Data;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    // Resource
    //required true-如果不存在注入类则启动失败 false-不存在也可以启动
    @Autowired(required = true) //primary
    Klass class1;
    
    @Resource(name = "student100")
    Student student100;
    
    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }

    @Override
    public void pang() {
        System.out.println("fucking coding!!!!");
    }

}
