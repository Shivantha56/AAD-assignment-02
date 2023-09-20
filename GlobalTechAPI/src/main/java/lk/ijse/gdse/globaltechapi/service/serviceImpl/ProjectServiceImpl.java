package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.repository.ProjectRepository;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.springframework.stereotype.Component;

import java.util.Base64;

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
}
