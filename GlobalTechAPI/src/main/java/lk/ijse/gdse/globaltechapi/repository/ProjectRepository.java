package lk.ijse.gdse.globaltechapi.repository;

import lk.ijse.gdse.globaltechapi.dto.ProjectDTO;

import lk.ijse.gdse.globaltechapi.entity.Project;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,String> {



}
