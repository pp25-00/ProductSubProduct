package com.Nav.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nav.Entity.Product;
import com.Nav.Entity.Subproduct;
import com.Nav.Repos.ProductRepo;
import com.Nav.Repos.SubRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Productservice {

	@Autowired
	private ProductRepo pr;
	@Autowired
	private SubRepo sr;

	public String createProduct(Product p) {
		log.info("Service Layer Call");
		log.info("data is :" + p);
		Product save = pr.save(p);
		log.info("Saved to Product");
		List<String> subUnits = new ArrayList<>();

		switch (p.getName().toLowerCase()) {
		case "sugar":

			subUnits = Arrays.asList("1Kg", "10Kg");
			break;
		case "tea":

			subUnits = Arrays.asList("200gm", "500gm", "1Kg");
			break;
		case "milk":

			subUnits = Arrays.asList("500ml", "1ltr");

			break;
		}

		for (String u : subUnits) {
			Subproduct sp = new Subproduct();
			sp.setName(p.getName() + " " + u);
			sp.setUnit(u);
			sp.setProduct(save);
			sr.save(sp);
			log.info("Saved Subproduct");
		}

		return "Saved sucessfully";
	}

	public List<Product> getall() {
		// TODO Auto-generated method stub

		List<Product> allproducts = pr.findAll();
		return allproducts;
	}

	public Product updateproduct(int id, Product p) {
		log.info("Service Layer Update Call");

		Product product = pr.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		product.setName(p.getName());
		product.setType(p.getType());
		product.setUnit(p.getUnit());

		log.info("Product updatedfrom db as " + product);
		return pr.save(product);

	}

	public String delete(int id) {
		// TODO Auto-generated method stub

		log.info("Service Laer delete Call to delete by id " + id);

		pr.deleteById(id);

		log.info("Deleted Product");
		return "Deleted product sucessfully";
	}

}
