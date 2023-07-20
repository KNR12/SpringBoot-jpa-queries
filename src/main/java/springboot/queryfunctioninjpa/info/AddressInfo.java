package springboot.queryfunctioninjpa.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.queryfunctioninjpa.enums.Country;
import springboot.queryfunctioninjpa.enums.States;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressInfo {

    private Long addressId;

    private String addressType;

    private String city;

    private States state;

    private Country country;



}
