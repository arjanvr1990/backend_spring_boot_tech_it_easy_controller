package com.novi.backend_spring_boot_tech_it_easy_controller.Dtos;


public class RemoteControllerInputDto {

    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Boolean smartTv;
    private Boolean voiceControl;
    private Boolean bluetooth;
    private Integer originalStock;
    private Integer sold;

    private String batteryType;
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

    public String getBatteryType() {return batteryType;}

    public void setBatteryType(String batteryType) {this.batteryType = batteryType;}


    public String getCompatibleWith() {return compatibleWith; }

    public void setCompatibleWith(String compatibleWith) {this.compatibleWith = compatibleWith;}

}
