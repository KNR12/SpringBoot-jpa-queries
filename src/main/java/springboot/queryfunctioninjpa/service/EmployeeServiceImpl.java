package springboot.queryfunctioninjpa.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import springboot.queryfunctioninjpa.info.AddressInfo;
import springboot.queryfunctioninjpa.info.DepartmentInfo;
import springboot.queryfunctioninjpa.info.EmployeeInfo;
import springboot.queryfunctioninjpa.info.KeyInfo;
import springboot.queryfunctioninjpa.model.Address;
import springboot.queryfunctioninjpa.model.Department;
import springboot.queryfunctioninjpa.model.Employee;
import springboot.queryfunctioninjpa.respository.AddressRespository;
import springboot.queryfunctioninjpa.respository.EmployeeRespository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRespository employeeRespository;

    private AddressRespository addressRespository;

   @Override
    public KeyInfo findById(Long id) {
       Optional<Employee> employeeDetails = employeeRespository.findById(id);
       Employee employee1;

       if (employeeDetails.isPresent()) {
           employee1 = employeeDetails.get();
       } else {
           //we didnt find the employee
           throw new RuntimeException("Did not find employee id-" + id);
       }
       List<Address> addressLists = employee1.getAddresses();
       List<AddressInfo> addressInfoList = new ArrayList<>();
       ModelMapper modelMapper = new ModelMapper();
       for (Address address :  addressLists) {
           AddressInfo addressInfos = modelMapper.map(address, AddressInfo.class);
           addressInfoList.add(addressInfos);
       }
       Department department = employee1.getDepartment();
       DepartmentInfo departmentInfo = modelMapper.map(department, DepartmentInfo.class);

       KeyInfo keyInfo = modelMapper.map(employee1, KeyInfo.class);
       keyInfo.setDepartment(departmentInfo);
       keyInfo.setAddressList(addressInfoList);
       return (keyInfo);
   }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRespository.getAllEmployees();
    }

    @Override
    public Page<Employee>findEmployeesWithPagination(int offset,int pageSize){
       Page<Employee>employees=employeeRespository.findAll(PageRequest.of(offset, pageSize));
       return employees;
    }

    @Override
    public List<Employee> findByName(String name) {
       List<Employee> employees=employeeRespository.findByName(name);
       if(ObjectUtils.isEmpty(employees)) {
           throw new RuntimeException("employee name not found");
       }
        return employees;

    }

    @Override
    public List<Employee> findBySalary(Double salary) {
       List<Employee> employees=employeeRespository.findBySalary(salary);
       if(ObjectUtils.isEmpty(employees)) {
           throw new RuntimeException("employee salary not found");
       }
        return employees;
    }

    @Override
    public List<Employee> getEmployeeByNameOrSalary(String name, Double salary) {
        List<Employee> employees=employeeRespository.getEmployeeByNameOrSalary(name,salary);
        if(ObjectUtils.isEmpty(employees)) {
            throw new RuntimeException("name or salary not found");
        }
        return employees;
    }

/*    @Override
    public List<Employee> getEmployeeByNameAndSalary(String name, Double salary) {
        List<Employee> employees=employeeRespository.getEmployeeByNameAndSalary(name,salary);
        if(ObjectUtils.isEmpty(employees)) {
            throw new RuntimeException("name and salary are not match");
        }
        return employees;
    }

 */

    @Override
    public Employee save(EmployeeInfo employeeInfo) {
        List<AddressInfo> addressInfos = employeeInfo.getAddresses();
        List<Address> addresses = new ArrayList<Address>();
        ModelMapper modelMapper = new ModelMapper();
        for (AddressInfo addressInfoList : addressInfos) {
            Address address = modelMapper.map(addressInfoList, Address.class);
            addresses.add(address);
        }

            DepartmentInfo departmentInfo = employeeInfo.getDepartmentInfo();
            Department department = modelMapper.map(departmentInfo, Department.class);

            Employee employee = modelMapper.map(employeeInfo, Employee.class);
            employee.setAddresses(addresses);
            return employeeRespository.save(employee);

    }

    @Override
    public Employee updateEmployee(EmployeeInfo employeeInfo) {
        List<AddressInfo> addressInfoLists=employeeInfo.getAddresses();
        List<Address> addressDetails=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(AddressInfo addressInfo:addressInfoLists){
            Address address=modelMapper.map(addressInfo, Address.class);
            addressDetails.add(address);
        }
        DepartmentInfo departmentInfo=employeeInfo.getDepartmentInfo();
        Department department=modelMapper.map(departmentInfo, Department.class);

        Employee employee=modelMapper.map(employeeInfo, Employee.class);
        return employeeRespository.save(employee);
    }

    @Override
    public Integer updateEmployeeById(Long id, Double salary) {
        return employeeRespository.updateEmployeeById(id, salary);
    }

    @Override
    public Integer updateEmployeeByName(String name, Double salary) {
        return employeeRespository.updateEmployeeByName(name,salary);
    }

    /*@Override
    public void deleteByName(@Param("name") String name) {
       employeeRespository.deleteyByName(name);

    }

     */

    @Override
    public List<Employee> max() {
        List<Employee> employees=employeeRespository.max();
        return employees;
    }

    @Override
    public List<Employee> thirdHighestSalary() {
        List<Employee>employees=employeeRespository.thirdHighestSalary();
        return employees;
    }
    @Override
    public List<Employee> min() {
        List<Employee> employees=employeeRespository.min();
        return employees;
    }
    @Override
    public List<Employee> fifthLowestSalary() {
        List<Employee> employees=employeeRespository.fifthLowestSalary();
        return employees;
    }

    @Override
    public Double salaryOfAllEmployees() {
       return employeeRespository.salaryOfAllEmployees();

    }

    @Override
    public List<Double> avgSalary() {
        return employeeRespository.avgSalary();
    }

    @Override
    public Double avgSalaryOfAllEmployees() {
        return employeeRespository.avgSalaryOfAllEmployees();
    }

    @Override
    public List<String> findCancat() {
        return employeeRespository.findCancat();
    }


}
