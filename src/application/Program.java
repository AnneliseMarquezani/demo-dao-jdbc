package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller fidByID ===");		
		Seller seller = sellerDao.findByID(3);		
		System.out.println(seller);
		
		System.out.println("=== TEST 2 : seller fidByDepartment ===");
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TEST 3 : seller fidAll===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TEST 4 : seller insert===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insertes! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5 : seller update===");
		seller = sellerDao.findByID(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		}
	
	}
