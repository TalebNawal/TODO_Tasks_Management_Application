package ma.ac.emi.info.taskmate.Service;


import lombok.AllArgsConstructor;
import ma.ac.emi.info.taskmate.Entities.Task;
import ma.ac.emi.info.taskmate.Repository.TaskRepository;
import ma.ac.emi.info.taskmate.dto.CountType;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> getTasks(){
        return taskRepository.getAllTaskDueDateDesc(Sort.Direction.DESC);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }


    @Transactional(readOnly = true)
    public Boolean existById(String id){
        return taskRepository.existsById(id);
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public void delete(String id){
        taskRepository.deleteById(id);
    }


    public List<CountType> getPercentageGroupByType(){
        return taskRepository.countTasksByType();
    }
}
