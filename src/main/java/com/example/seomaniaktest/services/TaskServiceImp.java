package com.example.seomaniaktest.services;

import com.example.seomaniaktest.dao.TaskRepository;
import com.example.seomaniaktest.dto.TaskDTO;
import com.example.seomaniaktest.entities.Task;
import com.example.seomaniaktest.map.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImp implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    // ###################################################################################
    @Override
    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }
    // ###################################################################################
    @Override
    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProject_Id(projectId);
    }
    // ###################################################################################
    @Override
    public List<TaskDTO> searchTasks(String title, String status) {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .filter(task -> (title == null || task.getTitle().contains(title)))
                .filter(task -> (status == null || task.getStatus().equals(status)))
                .map(TaskMapper::mapToTaskDTO)
                .collect(Collectors.toList());
    }
    // ###################################################################################

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = TaskMapper.mapToTask(taskDTO);
        task = taskRepository.save(task);
        return TaskMapper.mapToTaskDTO(task);
    }
    // ###################################################################################
    @Override
    public void deleteTask(Long taskId) {
        if(taskRepository.findById(taskId).isPresent()) {
            taskRepository.deleteById(taskId);
        }
    }
   // static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
 //   @Override
 //   public TaskDTO updateTask(TaskDTO taskDTO) {
   //     Optional<Task> taskOptional = taskRepository.findById(taskDTO.getId());
     //   if(taskOptional.isPresent()) {
       //     Task taskToUpdate = taskOptional.get();
         //   taskToUpdate.setTitle(taskDTO.getTitle());
           // taskToUpdate.setStatus(taskDTO.getStatus());
            //taskToUpdate.setDescription(taskDTO.getDescription());
           // taskToUpdate.setDueDate(LocalDate.parse(taskDTO.getDueDate(), formatter));
           // taskRepository.save(taskToUpdate);
           // return TaskMapper.mapToTaskDTO(taskToUpdate);
       // }
       // return null;
   // }
    // ###################################################################################

}
// ###################################################################################
