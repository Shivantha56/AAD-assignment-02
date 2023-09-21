package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import com.mysql.cj.xdevapi.SessionFactory;
import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.repository.ProjectRepository;
import lk.ijse.gdse.globaltechapi.repository.TechLeadRepository;
import lk.ijse.gdse.globaltechapi.service.ProjectService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
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
            throw new RuntimeException("Tech lead can not find with that id");
        }

//        Project projectEntity = entityDTOConversion.getProjectEntity(projectDTO);
//        projectRepository.save(new Project(projectEntity.getProjectId(),projectEntity.getProjectName(),projectEntity.getDueDate()));
        return entityDTOConversion.getProjectDTO(project);
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
        ArrayList<ProjectDTO> getAll = new ArrayList<>();
        for (Project project : all) {

//            getAll.add(entityDTOConversion.getProjectDTO(new Project(project.getProjectId(),project.getProjectName(),project.getDueDate(),project.getTechLeadId())));
        }

        return getAll;

    }

    @Override
    public void update(String id) {
        //todo : have to implement in using custom created queries
    }
}
