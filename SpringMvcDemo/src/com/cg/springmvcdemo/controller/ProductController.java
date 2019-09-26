package com.cg.springmvcdemo.controller;

import java.util.List;

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
	public String addProduct(@ModelAttribute("product_details") Product product) {
		return "addProduct";
	}
	
	@RequestMapping(value = "/pagesubmit", method = RequestMethod.POST)
	public String addData(@ModelAttribute("product_details") Product product) {
		System.out.println(product);
		productservice.addProduct(product);
		return "home";
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
}
