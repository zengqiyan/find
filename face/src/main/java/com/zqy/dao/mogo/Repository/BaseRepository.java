package com.zqy.dao.mogo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class BaseRepository<T> {
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	protected MongoTemplate getMongoTemplate(){
		return mongoTemplate;
	}
	protected Class getEntityClass(){
		 Type genType = getClass().getGenericSuperclass();  
	     Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
	     return (Class) params[0]; 
	}
	public void save(T t){
		mongoTemplate.save(t);
	}
	public  void saveAndInc(T t){
		mongoTemplate.save(t);
	}
	public void delete(Query query){
		mongoTemplate.remove(query, getEntityClass());
   }
	public void delete(T t){
		mongoTemplate.remove(t);
	}
	public void deleteById(String id) {
		try {
		 Criteria criteria = Criteria.where("_id").in(id);
	        if(null!=criteria){
	            Query query = new Query(criteria);
	            if(null!=query && findOne(query)!=null){
	               delete(query);
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除出错");
		}
	}	
	public void updateFirst(Query query,Update update){
		try {
			mongoTemplate.updateFirst(query, update, getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新出错");
		}
	}
	public void updateMulti(Query query,Update update){
		try {
			mongoTemplate.updateMulti(query, update,getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新出错");
		}
	}
	public void upsert(Query query,Update update){
		try {
			mongoTemplate.upsert(query,update,getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新出错");
		}
	}

	public T findById(int id) {
		Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        return (T) mongoTemplate.findOne(query,this.getEntityClass());
	}
	public List<T> findList(Query query) {
		List<T> list= null;
		try {
			mongoTemplate.find(query, this.getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询出错");
		}
		return list;
	}
	public List<T> findAll() {
		List<T> list= null;
		try {
			list = mongoTemplate.findAll(this.getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询出错");
		}
		return list;
	}
	
	public T findOne(Query query) {
		T t = null;
		try {
		 t = (T) mongoTemplate.find(query, this.getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询出错");
		}
		return t;
	}
	public List<T> findPage(Query query, int start, int size) {
		 List<T> list = null;
		 try {
		  query.skip(start);
          query.limit(size);
          list = this.mongoTemplate.find(query, this.getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询出错");
		}
		return list;
	}
	public Long getPageCount(Query query) {
		long count=0l;
		 try {
			 count = this.mongoTemplate.count(query, this.getEntityClass());
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException("查询出错");
		 }
		 return count;
	}
}
