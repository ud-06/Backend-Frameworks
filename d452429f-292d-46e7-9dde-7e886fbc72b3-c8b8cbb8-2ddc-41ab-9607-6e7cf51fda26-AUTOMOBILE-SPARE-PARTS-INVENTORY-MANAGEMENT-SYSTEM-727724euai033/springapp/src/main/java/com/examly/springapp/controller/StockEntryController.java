package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.StockEntry;
import com.examly.springapp.service.StockEntryService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock-entries")
public class StockEntryController {
  
  @Autowired
  private StockEntryService stockEntryService;
  
  @PostMapping
  public ResponseEntity<StockEntry> createStockEntry(@RequestBody StockEntry stockEntry) {
    StockEntry savedStockEntry = stockEntryService.saveStockEntry(stockEntry);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStockEntry);
  }
  
  @GetMapping
  public ResponseEntity<List<StockEntry>> getAllStockEntries() {
    List<StockEntry> stockEntries = stockEntryService.getAllStockEntries();
    if (stockEntries.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.ok(stockEntries);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<StockEntry> getStockEntryById(@PathVariable Long id) {
    Optional<StockEntry> stockEntry = stockEntryService.getStockEntryById(id);
    return stockEntry.map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<StockEntry> updateStockEntry(@PathVariable Long id, @RequestBody StockEntry stockEntry) {
    StockEntry updatedStockEntry = stockEntryService.updateStockEntry(id, stockEntry);
    return ResponseEntity.ok(updatedStockEntry);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStockEntry(@PathVariable Long id) {
    stockEntryService.deleteStockEntry(id);
    return ResponseEntity.ok().build();
  }
}

