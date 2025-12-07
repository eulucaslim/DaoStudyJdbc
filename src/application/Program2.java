package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1 department insert ====");
        Department dep = new Department(null, "Human Resources");
        departmentDao.insert(dep);
        System.out.println("Create new department, this id = " + dep.getId());

        System.out.println("=== TEST 2 department update ====");
        Department department = new Department(3, "Tecnologia");
        departmentDao.update(department);
        System.out.println("Updated department, this id = " + department.getId());

        System.out.println("=== TEST 3 department delete ====");
        departmentDao.deleteById(10);
        System.out.println("Deleted department completed!");

        System.out.println("=== TEST 4 department findById ====");
        dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("=== TEST 5 department findAll ====");
        List<Department> deps = departmentDao.findAll();
        deps.forEach(System.out::println);




    }
}
