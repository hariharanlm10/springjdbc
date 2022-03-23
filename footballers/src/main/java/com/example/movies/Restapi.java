package com.example.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restapi {
	
	@Autowired
	Repo repo;
	
	@GetMapping("/paymentdb/count")
	int getCountOfLearners() {
		return repo.getCountAccount();
	}
	
	@GetMapping("/paymentdb/account")
	List<paymentdb> getAll(){
		return repo.getAll();
	}
	
	@PostMapping ("/paymentdb/add")
	void Add(@RequestBody paymentdb payment) {
		repo.Add(payment);
	}
	
	
	@PutMapping("/paymentdb/update/{id}")
	void Update(@RequestBody paymentdb payment,@PathVariable int id) {
		repo.Update(payment, id);
	}
	
	@DeleteMapping("/paymentdb/delete/{id}")
	void Delete(@PathVariable int id){
		repo.Delete(id);	
	}

}
