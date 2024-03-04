package homework.homework38.Service;

import homework.homework38.Model.Tasks;

import java.util.List;

public interface TasksOperation {
    List<Tasks> addTask(int id, String task, String deadline);
    int deleteTask(int id);
    List<Tasks> getTasks();
    int updateTask(Tasks tasks);
    List<Tasks> getTaskById(int id);
}
