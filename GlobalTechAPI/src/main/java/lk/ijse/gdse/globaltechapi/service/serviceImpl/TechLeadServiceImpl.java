package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.repository.TechLeadRepository;
import lk.ijse.gdse.globaltechapi.service.TechLeadService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class TechLeadServiceImpl implements TechLeadService {

    EntityDTOConversion entityDTOConversion;
    TechLeadRepository techLeadRepository;

    public TechLeadServiceImpl(EntityDTOConversion entityDTOConversion,TechLeadRepository techLeadRepository) {
        this.entityDTOConversion = entityDTOConversion;
        this.techLeadRepository = techLeadRepository;
    }

    @Override
    public TechLeadDTO save(TechLeadDTO techLeadDTO) {
        System.out.println("this is the save method in service pacjage: " + techLeadDTO.getName()+techLeadDTO.getEmployeeId());
        //base 64 configuration
        String imageEncode = Base64.getEncoder().encodeToString(techLeadDTO.getProfile());
        TechLead techLeadEntity = entityDTOConversion.getTechLeadEntity(techLeadDTO);
        techLeadEntity.setProfileImage("this is image 01");
        techLeadRepository.save(techLeadEntity);
        return techLeadDTO;
    }
}
