package ma.ac.emi.info.taskmate;

import ma.ac.emi.info.taskmate.Controller.TaskController;
import ma.ac.emi.info.taskmate.Entities.Task;
import ma.ac.emi.info.taskmate.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TaskmateApplication {


    @Autowired
    TaskController taskController;
    public static void main(String[] args) {
        SpringApplication.run(TaskmateApplication.class, args);


    }

}
