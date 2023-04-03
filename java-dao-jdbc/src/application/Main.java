package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entity.Department;
import model.entity.Seller;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        SellerDAO sellerDao = DAOFactory.createSellerDAO();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll =====");
        List<Seller>list1 = sellerDao.findAll();
        for (Seller obj : list1) {
            System.out.println(obj);
        }

//        System.out.println("\n=== TEST 4: seller insert =====");
//        Seller newSeller = new Seller(null,"Gustavo","Gustavo@gmail.com",new Date(),4000.00,department);
//        sellerDao.insert(newSeller);
//        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update =====");
        Seller updateSeller = sellerDao.findById(1);
        updateSeller.setEmail("Maria@gmail.com");
        sellerDao.update(updateSeller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: seller update =====");
        System.out.print("Enter ID for delete test: ");
        int code = input.nextInt();
        sellerDao.deleteById(code);
        System.out.println("Delete completed");
        input.close();
    }
}
