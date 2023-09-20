package lk.ijse.gdse.globaltechapi.service.serviceImpl;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.entity.TechLead;
import lk.ijse.gdse.globaltechapi.repository.TechLeadRepository;
import lk.ijse.gdse.globaltechapi.service.TechLeadService;
import lk.ijse.gdse.globaltechapi.util.EntityDTOConversion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        System.out.println(techLeadDTO.getProfileImage());
        TechLead techLeadEntity = entityDTOConversion.getTechLeadEntity(techLeadDTO);
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

    @Override
    public String deleteTechLead(String id) {
        techLeadRepository.deleteById(id);
        return "TechLead Delete Success";
    }

    @Override
    public void updateTechLead(String id,TechLeadDTO techLeadDTO) {
        boolean b = techLeadRepository.existsById(id);

        if (techLeadRepository.existsById(id)){
            techLeadRepository.save(new TechLead(techLeadDTO.getEmployeeId(),techLeadDTO.getName(),techLeadDTO.getEmail(),techLeadDTO.getProfileImage()));
        }else {
            throw new RuntimeException("TechLead cannot found");
        }

    }


}
