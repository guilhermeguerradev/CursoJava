import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1 : Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2 : Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3 : Seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        ///System.out.println("=== TEST 4 : seller insert ===");
        ///Seller newSeller = new Seller(null , "Guilherme Guerra" , "guilhermeguerradev@gmail.com", LocalDate.now(), 50000.0, department);
        ///sellerDao.insert(newSeller);
        ///System.out.println("Inserted! New id = " + newSeller.getId() );

        System.out.println("=== TEST 5 : seller update ===");
        seller = sellerDao.findById(8);
        seller.setName("Gustavo Guerra");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("=== TEST 6 : seller Delete ===");
        System.out.println("Enter id for delete test: ");
        int id = input.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted");




        input.close();

    }
}