package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.StockMovement;
import com.examly.springapp.service.StockMovementService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {
  
  @Autowired
  private StockMovementService stockMovementService;
  
  @PostMapping
  public ResponseEntity<StockMovement> createStockMovement(@RequestBody StockMovement stockMovement) {
    StockMovement savedStockMovement = stockMovementService.saveStockMovement(stockMovement);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStockMovement);
  }
  
  @GetMapping
  public ResponseEntity<List<StockMovement>> getAllStockMovements() {
    List<StockMovement> stockMovements = stockMovementService.getAllStockMovements();
    if (stockMovements.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(stockMovements);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
    Optional<StockMovement> stockMovement = stockMovementService.getStockMovementById(id);
    return stockMovement.map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<StockMovement> updateStockMovement(@PathVariable Long id, @RequestBody StockMovement stockMovement) {
    StockMovement updatedStockMovement = stockMovementService.updateStockMovement(id, stockMovement);
    return ResponseEntity.ok(updatedStockMovement);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
    stockMovementService.deleteStockMovement(id);
    return ResponseEntity.ok().build();
  }
}

