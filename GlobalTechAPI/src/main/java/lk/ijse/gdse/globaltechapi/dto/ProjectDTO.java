package lk.ijse.gdse.globaltechapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String dueDate;
    private String techLeadId;
}
