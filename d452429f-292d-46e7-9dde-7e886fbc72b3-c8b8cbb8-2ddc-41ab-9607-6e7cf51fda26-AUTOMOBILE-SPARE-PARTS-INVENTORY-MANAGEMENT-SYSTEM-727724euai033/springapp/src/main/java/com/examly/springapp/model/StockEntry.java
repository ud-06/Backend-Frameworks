package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class StockEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stockEntryId;
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  
  @ManyToOne
  @JoinColumn(name = "warehouse_id")
  private Warehouse warehouse;
  
  private int quantity;

  public StockEntry() {
  }

  public Long getStockEntryId() {
    return stockEntryId;
  }

  public void setStockEntryId(Long stockEntryId) {
    this.stockEntryId = stockEntryId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

