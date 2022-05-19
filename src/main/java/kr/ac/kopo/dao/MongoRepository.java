package kr.ac.kopo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kr.ac.kopo.model.Book;

// MongoRepository<T> -> 제네릭으로 인터페이스의 유연성 대체, dao 대체
public class MongoRepository<T> {
	protected MongoTemplate mongo;

	// find의 파라미터에 넣을 필드를 이용해서 생성자 생성

	public MongoRepository(MongoTemplate mongo, String collectionName, Class<T> entityClass) {
		this.mongo = mongo;
		this.collectionName = collectionName;
		this.entityClass = entityClass;
	}

	protected String collectionName;
	protected Class<T> entityClass;

	public List<T> list() {
		// pager를 위한 객체
		Query query = new Query();
		
		// query: 메서드에 필요한 조건을 넣을 객체
		// entityClass: mapper의 resultType에 해당 -> DB의 JSON을 저장할 JAVA 객체
		// collecitonName: MongoDB의 collection명
		return mongo.find(query, entityClass, collectionName);
	}

	public void add(T item) {
		mongo.insert(item, collectionName);
	}
	
	// DB의 문서는 JSON이기 때문에 id 값을 int가 아닌 String으로 받아야 함
	public T item(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongo.findOne(query , entityClass, collectionName);
	}
	
	// findAndModify의 update 값으로 String을 받기 위해 파라미터를 Map으로 변경 -> 기존의 T item은 객체 타입이 제네릭이기 때문에 특정 메서드를 호출할 수 없음
	// DB의 문서는 JSON이기 때문에 id 값을 int가 아닌 String으로 받아야 함
	public void update(String id, Map<String, Object> item) {
		Query query = new Query(Criteria.where("_id").is(id));
		
		Update update = new Update();
		
		// Map으로 받아온 item의 필드값을 key 값으로 찾고
		// update에 key로 저장
		for(String key : item.keySet()) {
			update.set(key, item.get(key));
		}
		
		mongo.findAndModify(query, update, entityClass, collectionName);
	}
	
	// DB의 문서는 JSON이기 때문에 id 값을 int가 아닌 String으로 받아야 함
	public void delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		
		mongo.remove(query, collectionName);
	}
}
