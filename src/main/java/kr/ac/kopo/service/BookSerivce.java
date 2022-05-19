package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Book;

public interface BookSerivce {

	List<Book> list();

	void add(Book item);

	Book item(String bookid);

	void update(Book item);

	void delete(String bookid);

}
