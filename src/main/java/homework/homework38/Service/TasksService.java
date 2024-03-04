package homework.homework38.Service;

import homework.homework38.Model.Tasks;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.config.Task;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksService implements TasksOperation {
    private JdbcTemplate jdbcTemplate;

    public TasksService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tasks> addTask(int id, String task, String deadline) {
        return null;
    }

    @Override
    public int deleteTask(int id) {
        String sql = "delete from tasks where id=?";
        try {
            int counter = jdbcTemplate.update(sql, new Object[]{id});
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Tasks> getTasks() {
        List<Tasks> tasks = jdbcTemplate.query("SELECT * FROM tasks", new RowMapper<Tasks>() {

            @Override
            public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
                Tasks task = new Tasks();
                task.setId(rs.getInt("id"));
                task.setTask(rs.getString("task"));
                task.setDeadline(rs.getString("deadline"));
                return task;
            }
        });
        return tasks;
    }

    @Override
    public int updateTask(Tasks task) {
        String sql = "update  tasks set task=?, deadline=?  where id=?";
        try {
            int counter = jdbcTemplate.update(sql,
                    new Object[]{task.getId(), task.getDeadline(), task.getTask()});
            return counter;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public List<Tasks> getTaskById(int id) {
        List<Tasks> tasks = jdbcTemplate.query("SELECT * FROM tasks where id=?",
                new Object[] { id }, new RowMapper<Tasks>() {
                    @Override
                    public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tasks tasks = new Tasks();

                        tasks.setId(rs.getInt("id"));
                        tasks.setDeadline(rs.getString("deadline"));
                        tasks.setTask(rs.getString("tasks"));
                        return tasks;
                    }
                });
        return tasks;
    }
}
