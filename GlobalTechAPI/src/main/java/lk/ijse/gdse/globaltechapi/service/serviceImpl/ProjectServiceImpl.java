package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.repository.ProjectRepository;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    EntityDTOConversion entityDTOConversion;

    public ProjectServiceImpl(ProjectRepository projectRepository , EntityDTOConversion entityDTOConversion) {
        this.projectRepository = projectRepository;
        this.entityDTOConversion = entityDTOConversion;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project projectEntity = entityDTOConversion.getProjectEntity(projectDTO);
        projectRepository.save(new Project(projectEntity.getProjectId(),projectEntity.getProjectName(),projectEntity.getDueDate()));
        return projectDTO;
    }

    @Override
    public String delete(String id) {
        projectRepository.deleteById(id);
        return "project delete success";
    }

    @Override
    public ProjectDTO getProjectInfo(String id) {

//        Project byId = projectRepository.getById(id);
//        byId.setTechLeadId("no");
//        ProjectDTO projectDTO = entityDTOConversion.getProjectDTO(byId);
        Optional<Project> byId = projectRepository.findById(id);
        if (byId.isPresent()) {
            String projectId = byId.get().getProjectId();
            String projectName = byId.get().getProjectName();
            String dueDate = byId.get().getDueDate();
//            TechLead techLeadId = byId.get().getTechLeadId();

            return new ProjectDTO(projectId, projectName, dueDate);
        }

        return null;
        // todo : getInformation using the getByID();
//        return entityDTOConversion.getProjectDTO(new Project(byId.getProjectId(), byId.getProjectName(), byId.getDueDate(), byId.getTechLeadId()));
    }

    @Override
    public ArrayList<ProjectDTO> getAllProjects() {
        List<Project> all = projectRepository.findAll();
        ArrayList<ProjectDTO>getAll = new ArrayList<>();
        for (Project project:all) {

//            getAll.add(entityDTOConversion.getProjectDTO(new Project(project.getProjectId(),project.getProjectName(),project.getDueDate(),project.getTechLeadId())));
        }

        return getAll;

    }

    @Override
    public void update(String id) {
        //todo : have to implement in using custom created queries
    }
}
