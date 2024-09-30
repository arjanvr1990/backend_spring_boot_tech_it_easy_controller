package com.novi.backend_spring_boot_tech_it_easy_controller.dtos;


public class WallBracketDto {

    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Double availableSize;
    private Integer originalStock;
    private Integer sold;
    private String compatibleWith;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }


    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getCompatibleWith() {return compatibleWith; }

    public void setCompatibleWith(String compatibleWith) {this.compatibleWith = compatibleWith;}

}
