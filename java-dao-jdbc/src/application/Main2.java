package application;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entity.Department;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

        System.out.println("=== TEST 1: department find All ===");
        List<Department> findAllDepartment = departmentDAO.findAll();
        for (Department department : findAllDepartment){
            System.out.println(department);
        }

        System.out.println("=== TEST 2: department find by id ===");
        //Department dep = departmentDAO.findById(1);
        //System.out.println(dep);

        System.out.println("=== TEST 3: department delete by id ===");
        //departmentDAO.deleteById(6);
        System.out.println("Delete completed");

        System.out.println("=== TEST 4: department update by id ===");
        Department updateDepartment = departmentDAO.findById(3);
        updateDepartment.setName("Music");
        departmentDAO.update(updateDepartment);
        System.out.println("Update completed");

        System.out.println("=== TEST 5: department insert ===");
        Department dep = new Department(null, "Books");
        departmentDAO.insert(dep);
        System.out.println("Inserted! New id = " + dep.getId());
    }
}
