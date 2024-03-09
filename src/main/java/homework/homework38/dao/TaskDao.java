package homework.homework38.dao;

import homework.homework38.Model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tasks> index() {
        return jdbcTemplate.query("SELECT * FROM Tasks", new BeanPropertyRowMapper<>(Tasks.class));
    }

    public Tasks show(int id) {
        return jdbcTemplate.query("SELECT * FROM Tasks where id =?", new Object[]{id}, new BeanPropertyRowMapper<>(Tasks.class))
                .stream().findAny().orElse(null);
    }

    public void save(Tasks task) {
        jdbcTemplate.update("INSERT INTO Tasks (id, description, deadline) VALUES (?, ?, ?)", task.getId(), task.getDescription(), task.getDeadline());
    }


    public void update(int id, Tasks updatedTasks) {
       jdbcTemplate.update("UPDATE Tasks SET description = ?, deadline = ? WHERE id = ?", updatedTasks.getDescription(), updatedTasks.getDeadline(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Tasks WHERE id = ?", id);
    }

}
