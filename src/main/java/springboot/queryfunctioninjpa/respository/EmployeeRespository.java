package springboot.queryfunctioninjpa.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.queryfunctioninjpa.model.Employee;
import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {

   // List<Employee> findByName(String name);
    List<Employee> findBySalary(Double salary);
    @Query("select e from Employee e")
    public List<Employee> getAllEmployees();
    @Query("select e from Employee e where e.name=:name")
    public  List<Employee> findByName(@Param("name") String name);
    @Query("select e from Employee e where e.name=:name or e.salary=:salary")
    public List<Employee> getEmployeeByNameOrSalary(@Param("name") String name, @Param("salary") Double salary);
   /* @Query("select e from Employee e where e.name=:name and e.salary=:salary")
    public List<Employee> getEmployeeByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    */

  /*  @Query("Employee e where e.salary between :fromsalary and :tosalary")
    public List<Employee> getEmployeeSalaryBetween(Double fromsalary,Double tosalary);

   */
   /* @Modifying
    @Transactional
    @Query("delete from Employee where salary=:salary")
    public void deleteBySalary(@Param("salary") Double salary);*/
    @Modifying
    @Transactional
    @Query("update Employee set salary=:salary where id=:id")
    public Integer updateEmployeeById(Long id,Double salary);

    @Modifying
    @Transactional
    @Query("update Employee set salary=:salary where name=:name")
    public Integer updateEmployeeByName(String name,Double salary);

   /* @Transactional
    @Modifying
    @Query("delete FROM Employee e where e.name=:name")
   public void deleteyByName(@Param("name") String name);

    */

    @Query(value = "SELECT * FROM Employee e where e.salary=(select max(salary) from Employee)",nativeQuery = true)
    public List<Employee> max();

    @Query(value = "SELECT * FROM Employee e1 where 3 = (SELECT COUNT(DISTINCT salary)from Employee e2 where e2.salary > e1.salary)",nativeQuery = true)
    public List<Employee> thirdHighestSalary();

    @Query(value = "SELECT * FROM Employee e where e.salary=(select min(salary) from Employee)",nativeQuery = true)
    public List<Employee> min();

    @Query(value = "SELECT * FROM Employee e1 where 5= (SELECT COUNT(DISTINCT salary)from Employee e2 where e2.salary < e1.salary)",nativeQuery = true)
    public List<Employee> fifthLowestSalary();

    @Query(value="SELECT sum(salary) FROM Employee",nativeQuery = true)
    public Double salaryOfAllEmployees();

    @Query(value="select *,concat(e2.name,'  ',e2.email) fullName from Employee e2 ",nativeQuery = true)
    public Double avgSalaryOfAllEmployees();

    @Query(value="SELECT AVG(e.salary) FROM Employee e INNER JOIN Department d ON e.dpt_id = d.department_id and d.department_name='IT' GROUP BY d.department_name='IT'",nativeQuery = true)
    public List<Double> avgSalary();

    @Query(value="select *,concat(e2.name,'  ',e2.email) fullName from Employee e2",nativeQuery = true)
    public List<String> findCancat();

}


