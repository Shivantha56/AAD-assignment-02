package lk.ijse.gdse.globaltechapi.service.serviceImpl;


import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.exception.NotFoundException;
import lk.ijse.gdse.globaltechapi.repository.ProjectRepository;
import lk.ijse.gdse.globaltechapi.repository.TechLeadRepository;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    EntityDTOConversion entityDTOConversion;
    TechLeadRepository techLeadRepository;


    public ProjectServiceImpl(ProjectRepository projectRepository, EntityDTOConversion entityDTOConversion, TechLeadRepository techLeadRepository) {
        this.projectRepository = projectRepository;
        this.entityDTOConversion = entityDTOConversion;
        this.techLeadRepository = techLeadRepository;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO, String techLeadId) {

        Project project;

        Project projectEntity1 = entityDTOConversion.getProjectEntity(projectDTO);

        if (techLeadRepository.existsById(techLeadId)) { // coming lazy initialisation and session proxy error
            TechLead techLead = techLeadRepository.getById(techLeadId);
            System.out.println(techLead.getName());

            Set<Project> getProject = new HashSet<>();
            getProject.add(projectEntity1);
            techLead.setProjectSet(getProject);


            Project projectEntity = entityDTOConversion.getProjectEntity(projectDTO);
            projectRepository.save(project = new Project(projectEntity.getProjectId(), projectEntity.getProjectName(), projectEntity.getDueDate(), techLead));


        } else {
            throw new NotFoundException("Tech lead can not find with the provided id");
        }
        return entityDTOConversion.getProjectDTO(project);
    }

    @Override
    public String delete(String id) {

        if (projectRepository.existsById(id)) { // coming lazy initialisation and session proxy error
            projectRepository.deleteById(id);
            return "project delete success";
        }
        throw new NotFoundException("can not find project with provided id");
    }

    @Override
    public ProjectDTO getProjectInfo(String id) {


        Optional<Project> byId = projectRepository.findById(id);
        if (byId.isPresent()) {
            String projectId = byId.get().getProjectId();
            String projectName = byId.get().getProjectName();
            String dueDate = byId.get().getDueDate();
            return new ProjectDTO(projectId, projectName, dueDate);
        }

        return null;

    }

    @Override
    public ArrayList<ProjectDTO> getAllProjects() {
        List<Project> all = projectRepository.findAll();
        ArrayList<ProjectDTO> getAll = new ArrayList<>();
        for (Project project : all) {
            ProjectDTO projectDTO = entityDTOConversion.getProjectDTO(new Project(project.getProjectId(), project.getProjectName(), project.getDueDate(), project.getTechLeadId()));
            getAll.add(projectDTO);
        }
        return getAll;
    }

    @Override
    public void update(String id,ProjectDTO projectDTO) {
        if (projectRepository.existsById(id)){
            if (techLeadRepository.existsById(projectDTO.getTechLeadId())){
                TechLead techLead = techLeadRepository.getById(projectDTO.getTechLeadId());
                projectRepository.save(new Project(projectDTO.getProjectId(), projectDTO.getProjectName(), projectDTO.getDueDate(),techLead));
            }else {
                throw new NotFoundException("Tech lead can not found with that provided id");
            }

        }else {
            throw new NotFoundException("project cannot found");
        }

    }

}
