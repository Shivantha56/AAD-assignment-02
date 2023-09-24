package lk.ijse.gdse.globaltechapi.dto;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Data
public class TechLeadDTO {

    private String employeeId;
    private String name;
    private String email;
    @Lob
    private String profileImage;

    public TechLeadDTO(String employeeId, String name, String email, String profileImage) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }

    public TechLeadDTO(String name, String email, String profile) {
        this.name = name;
        this.email = email;
        this.profileImage = profile;
    }
}
