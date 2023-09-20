package lk.ijse.gdse.globaltechapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Project {
    @Id
    private String projectId;
    @Column(nullable = false)
    private String projectName;
    @Column(nullable = false)
    private String dueDate;
    @Column(columnDefinition = "VARCHAR (255) default 'techLead not assign'")
    private String techLeadId;

    public Project(String projectId, String projectName, String dueDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.dueDate = dueDate;
    }
}
