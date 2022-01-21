package com.mongo.mongocrud.service;

import com.mongo.mongocrud.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto createProducto(Producto producto);
    Producto findByNombre(String nombre);
    List<Producto> findAll();
    List<Producto> findByPrecioGreaterThan(int precio);
    List<Producto> findByPrecioOrderByNombreDesc(int precio);
    void updateFirstProductosNombreByPrecio(Producto producto, int precio);
    List<Producto> findAllAllByPrecioSortedLimit(String categoria, String orderBy, int limit);
}
