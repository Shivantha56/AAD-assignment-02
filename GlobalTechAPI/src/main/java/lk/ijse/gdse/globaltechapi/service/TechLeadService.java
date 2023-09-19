package lk.ijse.gdse.globaltechapi.service;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface TechLeadService {

    TechLeadDTO save(TechLeadDTO techLeadDTO);
    ArrayList<TechLeadDTO> getAll();

    TechLeadDTO getTechLeadInfo(String id);

}
