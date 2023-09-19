package lk.ijse.gdse.globaltechapi.api;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.ArrayList;
import java.util.Base64;

@MultipartConfig()
@RestController
@RequestMapping("/api/v1/techlead")
public class TechLeadController {
    @Autowired
    TechLeadService techLeadService;

    @GetMapping(path = "/test")
    public String testApi(){
        return "tech lead api test ok";
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public TechLeadDTO saveTechLead(@RequestPart String employeeId,
                             @RequestPart String name,
                             @RequestPart String email,
                             @RequestPart byte[] profile){

        // todo : crate using Model attribute
//        String id = techLeadDTO.getEmployeeId();
//        String name = techLeadDTO.getName();
//        String email = techLeadDTO.getEmail();
//        String profileImage = Base64.getEncoder().encodeToString(profile);
        return techLeadService.save(new TechLeadDTO(employeeId,name,email,profile));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TechLeadDTO> getAllTechLead(){
        System.out.println("get all tech lead");
        ArrayList<TechLeadDTO> all = techLeadService.getAll();
        System.out.println(all);
        return all;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "{id}")
    public TechLeadDTO getTechLeadInfo(@PathVariable String id){
        return techLeadService.getTechLeadInfo(id);
    }

    @DeleteMapping
    public void deleteTechLead(){
        System.out.println("delete mapping");
    }
    @PutMapping
    public void updateTechLead(){

    }

}
