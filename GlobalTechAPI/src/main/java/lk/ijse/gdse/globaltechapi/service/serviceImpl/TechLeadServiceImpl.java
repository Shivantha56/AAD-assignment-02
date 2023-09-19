package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.repository.TechLeadRepository;
import lk.ijse.gdse.globaltechapi.service.TechLeadService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import net.bytebuddy.matcher.StringMatcher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ArrayList<TechLeadDTO> getAll() {
        ArrayList<TechLeadDTO> getAllDTO = new ArrayList<>();
        List<TechLead> all = techLeadRepository.findAll();

        for (TechLead get: all) {
            TechLeadDTO techLeadDTO = entityDTOConversion.getTechLeadDTO(get);
            boolean add = getAllDTO.add(techLeadDTO);
            System.out.println(add);
        }
        return getAllDTO;
    }

    @Override
    public TechLeadDTO getTechLeadInfo(String id) {
        Optional<TechLead> byId = techLeadRepository.findById(id);
        TechLead techLead = null;
        if (byId.isPresent()) {
            techLead = byId.get();
        }
        return entityDTOConversion.getTechLeadDTO(techLead);

    }


}
