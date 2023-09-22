package lk.ijse.gdse.globaltechapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Project implements SuperEntity {
    @Id
    private String projectId;
    @Column(nullable = false)
    private String projectName;
    @Column(nullable = false)
    private String dueDate;
    @ManyToOne
    private TechLead techLeadId;

//    public Project(String projectId, String projectName, String dueDate, TechLead techLeadId) {
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.dueDate = dueDate;
//        this.techLeadId = techLeadId;
//    }

    public Project(String projectId, String projectName, String dueDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.dueDate = dueDate;
    }
}
