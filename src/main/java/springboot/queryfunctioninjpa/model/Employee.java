package springboot.queryfunctioninjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fname", length=32, nullable=false)
    private String fname;

    @Column(name="lname", length=32, nullable=false)
    private String lname;
    @Column(name="email", length=32, nullable=false)
    private String email;

    @Column(name="salary",length=16)
    private Double salary;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private List<Address> addresses;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="dpt_id")
    private Department department;
}