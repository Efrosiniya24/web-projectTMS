package homework.homework38.Controller;


import homework.homework38.Model.Tasks;
import homework.homework38.Service.TasksService;
import homework.homework38.dao.TaskDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TasksController {
    private final TaskDao taskDao;

    @Autowired
    public TasksController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskDao.index());
        return "allTasks";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("tasks") @Valid Tasks tasks,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "allTasks";

        taskDao.save(tasks);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskDao.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("person") @Valid Tasks tasks, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "allTasks";

        taskDao.update(id, tasks);
        return "redirect:/";
    }

}
