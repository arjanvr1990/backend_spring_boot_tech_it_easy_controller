package com.novi.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;

@Entity
public class WallBracket {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;

    private Double availableSize;
    private Integer originalStock;
    private Integer sold;

    //WallBracket//
    private String compatibleWith;




    public WallBracket() {

    }


    public WallBracket(Long id, String type, String brand, String name, Double price, Double availableSize, Integer originalStock, Integer sold, String compatibleWith){

        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.originalStock = originalStock;
        this.sold = sold;

        //Wall Bracket//
        this.compatibleWith =compatibleWith;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //Wall Bracket//
    public String getCompatibleWith() {return compatibleWith; }

    public void setCompatibleWith(String compatibleWith) {this.compatibleWith = compatibleWith;}

}
