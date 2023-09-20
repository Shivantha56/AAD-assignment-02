package lk.ijse.gdse.globaltechapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TechLeadDTO {

    private String employeeId;
    private String name;
    private String email;
    private String profile;

    public TechLeadDTO(String name, String email, String profile) {
        this.name = name;
        this.email = email;
        this.profile = profile;
    }
}
