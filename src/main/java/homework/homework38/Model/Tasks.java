package homework.homework38.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    private int id;

    @NotEmpty(message = "Task should not be empty")
    @Size(min = 1, max = 10000, message = "Task should be between 1 and 10000 characters")
    private String description;


    @NotEmpty(message = "Deadline should not be empty")
    @Size(min = 1, max = 10000, message = "Deadline should be between 1 and 10000 characters")
    private String deadline;
}
