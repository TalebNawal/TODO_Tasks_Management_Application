package ma.ac.emi.info.taskmate.Repository;

import lombok.AllArgsConstructor;
import ma.ac.emi.info.taskmate.Entities.Task;
import ma.ac.emi.info.taskmate.dto.CountType;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends MongoRepository<Task,String> {

    Task save(Task task);




    @Query("{ }")
    public List<Task> getAllTaskDueDateDesc(Sort.Direction sort);


    @org.springframework.data.mongodb.repository.Aggregation(pipeline = {
            "{ $group: { _id: '$type', count: { $sum: 1 } } }",
            "{ $project: { type: '$_id', count: 1, _id: 0 } }"
    })
            List<CountType> countTasksByType();



}