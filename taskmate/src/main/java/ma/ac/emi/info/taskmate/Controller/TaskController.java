package ma.ac.emi.info.taskmate.Controller;


import lombok.AllArgsConstructor;
import ma.ac.emi.info.taskmate.Entities.Task;
import ma.ac.emi.info.taskmate.Service.TaskService;
import ma.ac.emi.info.taskmate.dto.CountType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin
public class TaskController {

    private TaskService taskService;



    @GetMapping("/task/vData/percentcounttype")
    public List<CountType> getPercentageGroupByType(){
        return taskService.getPercentageGroupByType();
    }
    @GetMapping("/task")
    public List<Task> getTask(){
       return taskService.getTasks();
    }


    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskService.getTaskById(id).get();
    }


    @PostMapping("/task")
    public Task addTask(@RequestBody Task task){
        return taskService.save(task);
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task taskPara, @PathVariable String id ){
        if( taskService.existById(id)){
            Optional<Task> task = taskService.getTaskById(id);
            task.get().setTitle(taskPara.getTitle());
            task.get().setType(taskPara.getType());
            task.get().setDueDate(taskPara.getDueDate());
            task.get().setDescription(taskPara.getDescription());
            taskService.save(task.get());
            return ResponseEntity.ok().body(task);
        }else {

            HashMap<String ,String> message = new HashMap<>();
            message.put("message",id +"task not found ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }


    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        if(taskService.existById(id)) {
            taskService.delete(id);
            HashMap<String, String>message= new HashMap<>();
            message.put("message", id + " task removed");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }else {
            HashMap<String, String>message= new HashMap<>();
            message.put("message", id + " task not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
