package lk.ijse.gdse.globaltechapi.api;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDTO saveProject(@RequestPart String projectId, @RequestPart String projectName, @RequestPart String dueDate){
        return projectService.save(new ProjectDTO(projectId,projectName,dueDate));
    }

    @GetMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDTO getProjectInfo(@PathVariable String id){
        return projectService.getProjectInfo(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteProject(@PathVariable String id){
        return projectService.delete(id);
    }

    @GetMapping
    public ArrayList<ProjectDTO> getAll(){
        return projectService.getAllProjects();
    }

    @PatchMapping(path = "{id}")
    public String updateProject(@PathVariable String id){
        projectService.update(id);
        return "project updated";
    }

}
