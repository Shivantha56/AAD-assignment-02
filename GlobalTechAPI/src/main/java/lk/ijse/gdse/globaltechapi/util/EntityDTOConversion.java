package lk.ijse.gdse.globaltechapi.util;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;
import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EntityDTOConversion {

    @Autowired
    ModelMapper modelMapper;

    public TechLeadDTO getTechLeadDTO(TechLead techLead){
        return modelMapper.map(techLead, TechLeadDTO.class);
    }
    public TechLead getTechLeadEntity(TechLeadDTO techLeadDTO){
       return modelMapper.map(techLeadDTO, TechLead.class);
    }
    public ProjectDTO getProjectDTO(Project project){
        return modelMapper.map(project, ProjectDTO.class);
    }
    public Project getProjectEntity(ProjectDTO projectDTO){
       return modelMapper.map(projectDTO, Project.class);
    }


}
