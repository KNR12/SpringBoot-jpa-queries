package springboot.queryfunctioninjpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import springboot.queryfunctioninjpa.info.EmployeeInfo;
import springboot.queryfunctioninjpa.info.KeyInfo;
import springboot.queryfunctioninjpa.model.Employee;

import java.util.List;

public interface EmployeeService {
    public KeyInfo findById(Long id);

    List<Employee>getAllEmployees();

    public Page<Employee> findEmployeesWithPagination(int offset, int pageSize);

    public  List<Employee> findByName(@Param("name") String name);

    List<Employee> findBySalary(Double salary);

    public List<Employee> getEmployeeByNameOrSalary(String name,Double salary);

   // public List<Employee> getEmployeeByNameAndSalary(String name,Double salary);

    public Employee save(EmployeeInfo employeeInfo);

    public Employee updateEmployee(EmployeeInfo employeeInfo);

    public Integer updateEmployeeById(Long id,Double salary);

    public Integer updateEmployeeByName(String name,Double salary);

   // public void deleteBySalary(Double salary);

//    void deleteByName(@Param("name") String name);

    public List<Employee> max();

    public List<Employee> min();

    public List<Employee> thirdHighestSalary();

    public List<Employee> fifthLowestSalary();

    public Double salaryOfAllEmployees();

    public List<Double> avgSalary();

    public Double avgSalaryOfAllEmployees();

    public List<String> findCancat();




}
