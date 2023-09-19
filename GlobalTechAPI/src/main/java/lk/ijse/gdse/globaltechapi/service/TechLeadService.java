package lk.ijse.gdse.globaltechapi.service;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import org.springframework.stereotype.Component;

@Component
public interface TechLeadService {

    TechLeadDTO save(TechLeadDTO techLeadDTO);

}
