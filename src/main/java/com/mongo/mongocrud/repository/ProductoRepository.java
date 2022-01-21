package com.mongo.mongocrud.repository;

import com.mongo.mongocrud.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    Producto findByNombre(String nombre);
    List<Producto> findByPrecioGreaterThan(int precio);
    List<Producto> findByPrecioOrderByNombreDesc(int precio);
}
