package application;

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
		
		System.out.println("=== TEST2 : seller fidByDepartment ===");
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		

	}

}
