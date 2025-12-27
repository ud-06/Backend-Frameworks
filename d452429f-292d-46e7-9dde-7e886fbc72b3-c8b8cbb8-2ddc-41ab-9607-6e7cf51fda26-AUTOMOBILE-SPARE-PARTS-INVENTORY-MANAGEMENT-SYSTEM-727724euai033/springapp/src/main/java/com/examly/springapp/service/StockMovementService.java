package com.examly.springapp.service;

import com.examly.springapp.model.StockMovement;
import java.util.List;
import java.util.Optional;

public interface StockMovementService {
  StockMovement saveStockMovement(StockMovement stockMovement);
  List<StockMovement> getAllStockMovements();
  Optional<StockMovement> getStockMovementById(Long id);
  StockMovement updateStockMovement(Long id, StockMovement stockMovement);
  void deleteStockMovement(Long id);
}

