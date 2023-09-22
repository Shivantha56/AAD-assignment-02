package lk.ijse.gdse.globaltechapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String dueDate;
    private String techLeadId;

//    public ProjectDTO(String projectId, String projectName, String dueDate, String techLeadId) {
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.dueDate = dueDate;
//        this.techLeadId = techLeadId;
//    }

    public ProjectDTO(String projectId, String projectName, String dueDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.dueDate = dueDate;
    }
}
