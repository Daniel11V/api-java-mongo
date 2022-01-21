package com.mongo.mongocrud.controller;

import com.mongo.mongocrud.model.Producto;
import com.mongo.mongocrud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    @Qualifier("productoServiceImpl")
    ProductoService producto;

    @GetMapping("")
    public List<Producto> findProductos(@RequestParam Optional<Integer> precio) {
        if (precio.isPresent()) {
            return producto.findByPrecioGreaterThan(precio.get());
        } else {
            return producto.findAll();
        }
    }

    @GetMapping("/all-sorted")
    public List<Producto> findAllByCategoriaSortedByPrecio(@RequestParam String categoria,
                                                  @RequestParam String orderBy,
                                                  @RequestParam int limit) {
        return producto.findAllAllByPrecioSortedLimit(categoria, orderBy, limit);
    }

//    @GetMapping("/")
//    public Producto findByName(@RequestParam String name) {
//        return producto.findByName(name);
//    }

    @PostMapping("")
    public Producto createProducto(@RequestBody Producto newProducto) {
        return producto.createProducto(newProducto);
    }


}
