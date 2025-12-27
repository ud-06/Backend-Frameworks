package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class StockMovement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stockMovementId;
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  
  @ManyToOne
  @JoinColumn(name = "warehouse_id")
  private Warehouse warehouse;
  
  private int quantity;
  private String movementType; // IN or OUT

  public StockMovement() {
  }

  public Long getStockMovementId() {
    return stockMovementId;
  }

  public void setStockMovementId(Long stockMovementId) {
    this.stockMovementId = stockMovementId;
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

  public String getMovementType() {
    return movementType;
  }

  public void setMovementType(String movementType) {
    this.movementType = movementType;
  }
}

