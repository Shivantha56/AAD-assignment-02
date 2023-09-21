package lk.ijse.gdse.globaltechapi.service;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;

import java.util.ArrayList;

public interface ProjectService {
    ProjectDTO save(ProjectDTO projectDTO,String techLeadId);
    String delete(String id);

    ProjectDTO getProjectInfo(String id);

    ArrayList<ProjectDTO> getAllProjects();

    void update(String id);
}
