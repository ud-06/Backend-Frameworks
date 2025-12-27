package com.examly.springapp.service;

import com.examly.springapp.model.StockEntry;
import java.util.List;
import java.util.Optional;

public interface StockEntryService {
  StockEntry saveStockEntry(StockEntry stockEntry);
  List<StockEntry> getAllStockEntries();
  Optional<StockEntry> getStockEntryById(Long id);
  StockEntry updateStockEntry(Long id, StockEntry stockEntry);
  void deleteStockEntry(Long id);
}

