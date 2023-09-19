package lk.ijse.gdse.globaltechapi.api;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/techlead")
public class TechLeadController {


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveTechLead(@ModelAttribute TechLeadDTO techLeadDTO){
        System.out.println("save techlead");
    }

    @GetMapping(produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void getAllTechLead(){
        System.out.println("get all tech lead");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "{id}")
    public void getTechLeadInfo(String id){
        System.out.println("get techlead");
    }

    @DeleteMapping
    public void deleteTechLead(){
        System.out.println("delete mapping");
    }
    @PutMapping
    public void updateTechLead(){

    }

}
