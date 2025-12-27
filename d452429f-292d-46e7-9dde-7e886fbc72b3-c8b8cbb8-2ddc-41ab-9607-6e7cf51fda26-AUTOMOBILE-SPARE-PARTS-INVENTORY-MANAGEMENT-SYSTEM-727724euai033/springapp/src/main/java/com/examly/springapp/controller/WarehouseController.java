package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
  
  @Autowired
  private WarehouseService warehouseService;
  
  @PostMapping
  public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
    Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouse);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedWarehouse);
  }
  
  @GetMapping
  public ResponseEntity<List<Warehouse>> getAllWarehouses() {
    List<Warehouse> warehouses = warehouseService.getAllWarehouses();
    if (warehouses.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(warehouses);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
    Optional<Warehouse> warehouse = warehouseService.getWarehouseById(id);
    return warehouse.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouse) {
    Warehouse updatedWarehouse = warehouseService.updateWarehouse(id, warehouse);
    return ResponseEntity.ok(updatedWarehouse);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
    warehouseService.deleteWarehouse(id);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/location/{location}")
  public ResponseEntity<?> getWarehousesByLocation(@PathVariable String location) {
    List<Warehouse> warehouses = warehouseService.getWarehousesByLocation(location);
    if (warehouses.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .body("No warehouses found at location: " + location);
    }
    return ResponseEntity.ok(warehouses);
  }
  
  @GetMapping("/location/{location}/name/{name}")
  public ResponseEntity<List<Warehouse>> getWarehousesByLocationAndName(
      @PathVariable String location, @PathVariable String name) {
    List<Warehouse> warehouses = warehouseService.getWarehousesByLocationAndName(location, name);
    return ResponseEntity.ok(warehouses);
  }
}
