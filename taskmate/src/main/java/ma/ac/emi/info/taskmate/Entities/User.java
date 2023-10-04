package ma.ac.emi.info.taskmate.Entities;

import jakarta.annotation.sql.DataSourceDefinitions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String username;

    private String password;

    // Getters and setters
}
