package springboot.queryfunctioninjpa.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInfo {

    private Long id;

    private String name;

    private String email;

    private Double salary;

    private List<AddressInfo> addresses;

    private DepartmentInfo departmentInfo;

}
