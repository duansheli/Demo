package com.fluffy.dao;

import org.springframework.data.repository.CrudRepository;

import com.fluffy.entity.DemoInfo;

/**
 * <pre>
 * 
 * http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#jpa.sample-app.finders.strategies
 * 
 * http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#repository-query-keywords
 * 
 * 分页语法
 * http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#repositories.limit-query-result
 * </pre>
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {

}
