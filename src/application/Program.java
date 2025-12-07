package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment =====");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);

        System.out.println("=== TEST 3: seller findAll =====");
        List<Seller> sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);

        System.out.println("=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id= " +  newSeller.getId());

        System.out.println("=== TEST 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed! for this id = " +  seller.getId());

        System.out.println("=== TEST 6: seller delete =====");
        seller = sellerDao.findById(1);
        sellerDao.deleteById(seller.getId());
        System.out.println("Update completed! for this id = " +  seller.getId());

    }
}
