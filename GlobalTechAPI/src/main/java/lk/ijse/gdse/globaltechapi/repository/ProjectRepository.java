package lk.ijse.gdse.globaltechapi.repository;

import lk.ijse.gdse.globaltechapi.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<TechLead,String> {

}
