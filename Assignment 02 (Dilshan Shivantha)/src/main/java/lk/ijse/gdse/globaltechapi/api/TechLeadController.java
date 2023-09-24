package lk.ijse.gdse.globaltechapi.api;

import lk.ijse.gdse.globaltechapi.dto.TechLeadDTO;
import lk.ijse.gdse.globaltechapi.exception.InvalidException;
import lk.ijse.gdse.globaltechapi.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if(employeeId == null || !employeeId.matches("(EMP-)[0-9]{3}")){
            throw new InvalidException("Invalid id");
        } else if (name == null) {
            throw new InvalidException("Invalid project name");
        } else if (email == null || email.matches("^\\\\S+@\\\\S+\\\\.\\\\S+$")) {
            throw new InvalidException("Invalid email");
        }else if (profile==null){
            throw new InvalidException("Invalid profile image");
        }

        // todo : crate using Model attribute
//        String id = techLeadDTO.getEmployeeId();
//        String name = techLeadDTO.getName();
//        String email = techLeadDTO.getEmail();
//        String profileImage = Base64.getEncoder().encodeToString(profile);
        String profileImage = Base64.getEncoder().encodeToString(profile);
        return techLeadService.save(new TechLeadDTO(employeeId,name,email,profileImage));
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
        if(id == null || !id.matches("(EMP-)[0-9]{3}")){
            throw new InvalidException("Invalid id");
        }
        return techLeadService.getTechLeadInfo(id);
    }

    @DeleteMapping(path = "{id}")
    public String deleteTechLead(@PathVariable String id){
        if(id == null || !id.matches("(EMP-)[0-9]{3}")){
            throw new InvalidException("Invalid id");
        }
        return techLeadService.deleteTechLead(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("{id}")
    public void updateTechLead(@PathVariable String id,
                               @RequestPart String name,
                               @RequestPart String email,
                               @RequestPart byte[] profile){
        if(id == null || !id.matches("(EMP-)[0-9]{3}")){
            throw new InvalidException("Invalid id");
        }

        String profileImage = Base64.getEncoder().encodeToString(profile);

        TechLeadDTO techLeadDTO = new TechLeadDTO(id,name,email,profileImage);
        techLeadService.updateTechLead(id,techLeadDTO);
    }

}
