package com.mongo.mongocrud.repository;

import com.mongo.mongocrud.model.Producto;

import java.util.List;

public interface ProductoTemplateRepository {

    List<Producto> findAllAllByPrecioSortedLimit(String categoria, String orderBy, int limit);
}
