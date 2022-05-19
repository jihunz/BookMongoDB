package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.service.BookSerivce;

@Controller
@RequestMapping("/book")
public class BookController {
	final String PATH = "book/";
	
	@Autowired
	BookSerivce service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Book> list = service.list();
		
		model.addAttribute("list", list);
		
		return PATH + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return PATH + "add";
	}
	
	@PostMapping("/add")
	public String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookid}")
	public String update(@PathVariable String bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return PATH + "update";
	}
	
	@PostMapping("/update/{bookid}")
	public String update(@PathVariable String bookid, Book item) {
		item.setBookid(bookid);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookid}")
	public String delete(@PathVariable String bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}
}
