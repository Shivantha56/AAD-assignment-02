package lk.ijse.gdse.globaltechapi.api;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.exception.InvalidException;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    final
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDTO saveProject(@RequestPart String projectId, @RequestPart String projectName, @RequestPart String dueDate, @RequestPart String techLeadId){

        if(projectId == null || !projectId.matches("P[0-9]{2}-[0-9]{3}")){
            throw new InvalidException("Invalid id");
        } else if (projectName == null) {
            throw new InvalidException("Invalid project name");
        } else if (dueDate == null || dueDate.matches("^[0-9]{1,2}\\\\/[0-9]{1,2}\\\\/[0-9]{4}$")) {
            throw new InvalidException("Invalid date format");
        }else if (techLeadId==null){
            throw new InvalidException("Invalid date format");
        }

        return projectService.save(new ProjectDTO(projectId,projectName,dueDate),techLeadId);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDTO getProjectInfo(@PathVariable String id){
        return projectService.getProjectInfo(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public String deleteProject(@PathVariable String id){
        return projectService.delete(id);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public ArrayList<ProjectDTO> getAll(){
        return projectService.getAllProjects();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(path = "{id}")
    public String updateProject(@PathVariable String id,@RequestPart String projectId, @RequestPart String projectName, @RequestPart String dueDate, @RequestPart String techLeadId){
        projectService.update(id,new ProjectDTO(projectId,projectName,dueDate,techLeadId));
        return "project updated";
    }


}
