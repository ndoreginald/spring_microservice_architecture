package org.ms.produitservice.web;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {

	@GetMapping("/config&")
	public Map<String,Object> config () {
	Map<String,Object> params = new Hashtable<>();
	params.put("threadName", Thread.currentThread().toString());
	return params;
	}
}
