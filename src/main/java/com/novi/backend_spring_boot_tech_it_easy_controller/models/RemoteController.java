package com.novi.backend_spring_boot_tech_it_easy_controller.models;

import jakarta.persistence.*;

@Entity
public class RemoteController {


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
    private Boolean smartTv;
    private Boolean voiceControl;
    private Boolean bluetooth;
    private Integer originalStock;
    private Integer sold;


    //Remote controller//
    private String batteryType;
    private String compatibleWith;




    public RemoteController() {

    }


    public RemoteController(Long id, String type, String brand, String name, Double price, Boolean smartTv, Boolean voiceControl, Boolean bluetooth, Integer originalStock, Integer sold, String batteryType, String compatibleWith){

        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.smartTv = smartTv;
        this.voiceControl = voiceControl;
        this.bluetooth = bluetooth;
        this.originalStock = originalStock;
        this.sold = sold;

        //Remote Controller//
        this.batteryType = batteryType;
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

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
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



    //Remote controller//
    public String getBatteryType() {return batteryType;}

    public void setBatteryType(String batteryType) {this.batteryType = batteryType;}


    public String getCompatibleWith() {return compatibleWith; }

    public void setCompatibleWith(String compatibleWith) {this.compatibleWith = compatibleWith;}
}
