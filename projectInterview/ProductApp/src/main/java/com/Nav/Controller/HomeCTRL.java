package com.Nav.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nav.Entity.Product;
import com.Nav.Service.Productservice;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeCTRL {

	@Autowired
	private Productservice ps;

	@PostMapping("/AddProducts")
	public ResponseEntity CreateProduct(@RequestBody Product p) {
		log.info("CTRl Layer Call");
		log.info("User data inserted " + p);

		ps.createProduct(p);

		return new ResponseEntity("Product Created Sucessfully", HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity Getall() {
		List<Product> ls = ps.getall();

		if (ls != null) {
			log.info("User are :" + ls);
			return new ResponseEntity("The list of user is " + ls, HttpStatus.OK);
		} else {
			log.warn("NO users returned List is Null");
			return new ResponseEntity("User NOT PRESENT", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable int id, @RequestBody Product p) {

		log.info("CTRL Layer Update Call");
		Product pro = ps.updateproduct(id, p);
		log.info("Updated Product is "+pro);
		return new ResponseEntity("The updated product is :"+pro,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletebyid(@PathVariable int id) {
		
		log.info("CTRL Layer Delete Call");
		
		return new ResponseEntity(ps.delete(id), HttpStatus.OK);
		
	}
	

}
