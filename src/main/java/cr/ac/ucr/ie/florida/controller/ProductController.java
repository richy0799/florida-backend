package cr.ac.ucr.ie.florida.controller;

import java.io.Console;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.florida.model.Product;
import cr.ac.ucr.ie.florida.service.ProductService;

@RestController
@RequestMapping ("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	private ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(productService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Product> saveProduct(@RequestBody Product product){
		try {
			Product productToInsert = productService.save(product);
			System.out.print(product);
			return ResponseEntity.created(new URI("/product/"+productToInsert.getProductId())).body(productToInsert);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteProduct (@PathVariable ("id") Long id){
		productService.deleteById(id);
		return ResponseEntity.ok(!(productService.findById(id)!=null));
		
	}

}
