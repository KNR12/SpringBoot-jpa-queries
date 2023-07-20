package springboot.queryfunctioninjpa.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.queryfunctioninjpa.info.EmployeeInfo;
import springboot.queryfunctioninjpa.info.KeyInfo;
import springboot.queryfunctioninjpa.model.Employee;
import springboot.queryfunctioninjpa.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employeeApi")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    //  "/employees" and return employees list


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
    return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{offset}/{pageSize}")
    public Page<Employee>findEmployeesWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        Page<Employee> employeePage=employeeService.findEmployeesWithPagination(offset, pageSize);
        return employeePage;
    }

    @GetMapping("/employees/")
    public KeyInfo getEmployee(@RequestParam Long id){
        KeyInfo theEmployee = employeeService.findById(id);
        return theEmployee;
    }

    @GetMapping("/employeename/")
    public List<Employee> getName(@RequestParam String name){
        return employeeService.findByName(name);

    }

    @GetMapping("/employeesalary/")
    public List<Employee> getSalary(@RequestParam Double salary) {
        return employeeService.findBySalary(salary);
    }

    @GetMapping("/employeenameorsalary")
    public List<Employee>getEmployeeByNameOrSalary(@RequestParam String name,@RequestParam Double salary){
        return employeeService.getEmployeeByNameOrSalary(name,salary);
    }

   /* @GetMapping("/employeenameAndsalary")
    public List<Employee>getEmployeeByNameAndSalary(@RequestParam String name,@RequestParam Double salary){
        return employeeService.getEmployeeByNameAndSalary(name,salary);
    }

    */
/*  @GetMapping("/getemployeesalarybetween")
    public List<Employee>getEmployeeSalaryBetween(@RequestParam Double fromsalary,@RequestParam Double tosalary){
        return employeeService.getEmployeeSalaryBetween(fromsalary, tosalary);
    }

 */

    @PutMapping("/employeeupdate")
    public Integer updateEmployeeById(@RequestParam Long id,@RequestParam Double salary){
        return employeeService.updateEmployeeById(id,salary);

    }

    @PutMapping("/employeeupdate1")
    public Integer updateEmployeeByName(@RequestParam String name,@RequestParam Double salary){
        return employeeService.updateEmployeeByName(name,salary);

    }

    //add mapping for POST>
    @PostMapping("/employee")
    public ResponseEntity createEmployee(@RequestBody EmployeeInfo employeeInfo) {

        employeeService.save(employeeInfo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("created successful");
    }
    @PutMapping("/employeeu")
    public ResponseEntity updateEmployee(@RequestBody EmployeeInfo employeeInfo){
        KeyInfo employee1=employeeService.findById(employeeInfo.getId());
        employeeService.updateEmployee(employeeInfo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("updated successful");
    }
   /* @DeleteMapping("/deleteemployees/")
    public String deleteEmployee(@RequestParam Double salary) {
        employeeService.deleteBySalary(salary);
        return "Deleted employee" ;
    }

    @DeleteMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam String name){
        employeeService.deleteByName(name);
        return "Deleted employee";
    }
    */
    @GetMapping("/maxsalary")
    public List<Employee> maxSalary(){
        return employeeService.max();
    }
    @GetMapping("/minsalary")
    public List<Employee> minSalary() {
        return employeeService.min();
    }
    @GetMapping("/3rdhighestsalary")
    public List<Employee> thirdHighestSalary() {
        return employeeService.thirdHighestSalary();
    }
    @GetMapping("/5thlowestsalary")
    public List<Employee> fifthLowestSalary() {
        return employeeService.fifthLowestSalary();
    }
    @GetMapping("allsalary")
    public Double salaryOfAllEmployees(){
        return employeeService.salaryOfAllEmployees();
    }
    @GetMapping("avgsalary")
    public List<Double> avgSalary(){
        return employeeService.avgSalary();
    }
    @GetMapping("avgsalaryall")
    public Double avgSalaryOfAllEmployees(){
        return employeeService.avgSalaryOfAllEmployees();
    }

    @GetMapping("findcancat")
    public List<String>findCancat(){
        return employeeService.findCancat();
    }

}
