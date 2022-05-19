package kr.ac.kopo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.MongoRepository;
import kr.ac.kopo.model.Book;

@Service
public class BookServiceImpl implements BookSerivce {
	@Autowired
	MongoRepository<Book> dao;
	
	@Override
	public List<Book> list() {
		return dao.list();
	}

	@Override
	public void add(Book item) {
		dao.add(item);
	}
	
	// dao에서 String으로 bookid를 받기 때문에 int -> String으로 변환하여 전달
	@Override
	public Book item(String bookid) {
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("bookid", item.getBookid());
		map.put("bookname", item.getBookname());
		map.put("publisher", item.getPublisher());
		map.put("price", item.getPrice());
		
		dao.update(String.valueOf(item.getBookid()), map);
	}
	
	// dao에서 String으로 bookid를 받기 때문에 int -> String으로 변환하여 전달
	@Override
	public void delete(String bookid) {
		dao.delete(bookid);
	}
}