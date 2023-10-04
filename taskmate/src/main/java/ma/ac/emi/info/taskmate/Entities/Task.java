package ma.ac.emi.info.taskmate.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ac.emi.info.taskmate.dto.CountType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "task")
public class Task {


   @Id
   private String id;
   private String title;
   private String type;
   private Date dueDate;
   private String description;


}
