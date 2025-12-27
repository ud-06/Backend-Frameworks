package com.examly.springapp.service;

import com.examly.springapp.model.Warehouse;
import java.util.List;
import java.util.Optional;

public interface WarehouseService {
  Warehouse saveWarehouse(Warehouse warehouse);
  List<Warehouse> getAllWarehouses();
  Optional<Warehouse> getWarehouseById(Long id);
  Warehouse updateWarehouse(Long id, Warehouse warehouse);
  void deleteWarehouse(Long id);
  List<Warehouse> getWarehousesByLocation(String location);
  List<Warehouse> getWarehousesByLocationAndName(String location, String name);
}
  
