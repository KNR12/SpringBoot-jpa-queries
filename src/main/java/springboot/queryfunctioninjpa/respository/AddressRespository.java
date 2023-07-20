package springboot.queryfunctioninjpa.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.queryfunctioninjpa.model.Address;

public interface AddressRespository extends JpaRepository<Address,Long> {
}
