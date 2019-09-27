package com.cg.springmvcdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcdemo.dto.Product;
import com.cg.springmvcdemo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productservice;
	//Can put any name in the value, need not to have same value
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="/add_page",method = RequestMethod.GET)
	public String addProduct(@ModelAttribute("product_details") Product product, Map<String, Object> model) {
		
		List<String> types=new ArrayList<String>();
		types.add("SELECT");
		types.add("Electronics");
		types.add("Grocery");
		types.add("Home appliances");
		
		List<String> features=new ArrayList<String>();
		features.add("No 3.5 mm audio jack");
		features.add("Fast charging");
		features.add("128GB ROM");
		features.add("64 GB ROM");
		
		model.put("dataItem", types);
		model.put("featureValues", features);
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/pagesubmit", method = RequestMethod.POST)
	public String addData(@Valid@ModelAttribute("product_details") Product product, BindingResult result,Map<String, Object> model) {
		
		if(result.hasErrors()) {
			List<String> types=new ArrayList<String>();
			types.add("SELECT");
			types.add("Electronics");
			types.add("Grocery");
			types.add("Home appliances");
			
			List<String> features=new ArrayList<String>();
			features.add("No 3.5 mm audio jack");
			features.add("Fast charging");
			features.add("128GB ROM");
			features.add("64 GB ROM");
			
			model.put("dataItem", types);
			model.put("featureValues", features);
			return "addProduct";
		}
		else {
			System.out.println(product);
			productservice.addProduct(product);
			return "home";
		}
		
	}
	
	@RequestMapping(value="/showdata", method=RequestMethod.GET)
	public ModelAndView getAllData() {
		List<Product> products=productservice.showProducts();
		return new ModelAndView("showAllProducts", "productdata", products);
	}
	
	@RequestMapping(value = "/delete_page", method = RequestMethod.GET)
	public String deleteData() {
		return "deleteProduct";
	}
	
	@RequestMapping(value="/deletedata",method=RequestMethod.POST)
	public String deletePage(@RequestParam("productid") int productId) {
		System.out.println(productId);
		productservice.removeProduct(productId);
		return "redirect:/showdata";
	}
	
	@RequestMapping(value="/search_page",method=RequestMethod.GET)
	public String searchProduct() {
		return "searchProduct";
	}
	
	@RequestMapping(value="/searchdata",method=RequestMethod.POST)
	public ModelAndView searchData(@RequestParam("productid") int productId) {
		System.out.println(productId);
		List<Product> products=new ArrayList<Product>();
		products.add(productservice.searchProduct(productId));
		System.out.println(products);
		return new ModelAndView("searchProduct", "productdata", products);
	}
	
}
