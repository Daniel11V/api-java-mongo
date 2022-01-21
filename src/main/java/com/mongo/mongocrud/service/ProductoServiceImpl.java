package com.mongo.mongocrud.service;

import com.mongo.mongocrud.model.Producto;
import com.mongo.mongocrud.repository.ProductoRepository;
import com.mongo.mongocrud.repository.ProductoTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;
    @Autowired
    private ProductoTemplateRepository template;

    @Override
    public Producto createProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Producto> findByPrecioGreaterThan(int precio) {
        return repository.findByPrecioGreaterThan(precio);
    }

    @Override
    public List<Producto> findByPrecioOrderByNombreDesc(int precio) {
        return repository.findByPrecioOrderByNombreDesc(precio);
    }

    @Override
    public void updateFirstProductosNombreByPrecio(Producto producto, int precio) {
//        var query = new Query();
//        query.addCriteria(Criteria.where("precio").is(precio));
//        var update = new Update();
//        update.set("phone", producto.getPhone());
//        template.updateMulti(query, update, Product.class);
    }

    @Override
    public List<Producto> findAllAllByPrecioSortedLimit(String categoria, String orderBy, int limit) {
        return template.findAllAllByPrecioSortedLimit(categoria, orderBy, limit);
    }
}
