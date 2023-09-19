package lk.ijse.gdse.globaltechapi.util;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
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


}
