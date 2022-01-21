package com.mongo.mongocrud.repository;

import com.mongo.mongocrud.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoTemplateRepositoryImpl implements ProductoTemplateRepository {

    @Autowired
    MongoTemplate template;

    @Override
    public List<Producto> findAllAllByPrecioSortedLimit(String categoria, String orderBy, int limit) {
        var query = new Query();
        query.with(Sort.by(
                orderBy.equalsIgnoreCase("DESC")
                        ? Sort.Order.desc("precio")
                        : Sort.Order.asc("precio")));
        query.limit(limit);
        query.addCriteria(Criteria.where("categoria").is(categoria));

        return template.find(query, Producto.class);
    }
}
