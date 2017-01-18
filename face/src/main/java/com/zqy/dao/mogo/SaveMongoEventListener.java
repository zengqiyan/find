package com.zqy.dao.mogo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ReflectionUtils;





public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Object> beforeSaveEvent) {
    	 if(beforeSaveEvent != null) {
    		 final Object source = beforeSaveEvent.getSource();
    		 if(source!=null){
             ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
 				@Override
 				public void doWith(Field field) throws IllegalArgumentException,
 						IllegalAccessException {
                     ReflectionUtils.makeAccessible(field);
                     if (field.isAnnotationPresent((Class<? extends Annotation>) GeneratedValue.class)) {
                    	 if(field.getLong(source)==0L){ //0L表示这个主键是初始值，需要自增。
                    		 field.set(source, getNextId(beforeSaveEvent.getCollectionName()));
                    	 }
                     }
 				}
             });
    		 }
         }        
    }
  /*  @Override
    public void onBeforeConvert(final BeforeConvertEvent<Object>  source) {
    	
        if(source != null) {
        	
            ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
				@Override
				public void doWith(Field field) throws IllegalArgumentException,
						IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    if (field.isAnnotationPresent(GeneratedValue.class)) {
                        //设置自增ID
                        field.set(source, getNextId(source.getClass().getSimpleName()));
                    }
				}
            });
        }
   }*/

 /**
  * 获取下一个自增ID
  * @author yinjihuan
  * @param collName  集合名
  * @return
  */
 private Long getNextId(String collName) {
     Query query = new Query(Criteria.where("collName").is(collName));
     Update update = new Update();
     update.inc("seqId", 1);
     FindAndModifyOptions options = new FindAndModifyOptions();
     options.upsert(true);
     options.returnNew(true);
     SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
     return seqId.getSeqId();
 }

}