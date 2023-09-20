package lk.ijse.gdse.globaltechapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "techlead")
public class TechLead implements SuperEntity {

    @Id
    private String employeeId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Lob
    @Column(nullable = false,columnDefinition = "LongText", length = 2000)
    private String profileImage;
    @OneToMany(mappedBy = "techLeadId")
    private Set<Project> projectSet;

//    public TechLead(String name, String email, String profileImage) {
//        this.name = name;
//        this.email = email;
//        this.profileImage = profileImage;
//    }

    public TechLead(String employeeId, String name, String email, String profileImage) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }
}
