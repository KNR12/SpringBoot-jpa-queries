package springboot.queryfunctioninjpa.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.queryfunctioninjpa.model.Department;

public interface DepartmentRespository extends JpaRepository<Department,Long> {
}
