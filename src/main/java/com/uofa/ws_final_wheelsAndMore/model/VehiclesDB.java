package com.uofa.ws_final_wheelsAndMore.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.sql.Date;

    @Entity
    @Table(name = "vehicles")
    public class VehiclesDB {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_vehicles;

        @NotEmpty(message = "Make cannot be empty. Please input data to continue.")
        @Column(name = "make")
        private String make;

        @NotEmpty(message = "Model cannot be empty. Please input data to continue.")
        @Column(name = "model")
        private String model;

        @Column(name = "type")
        private String type;

        @NotNull(message = "Purchase Price cannot be empty. Please enter price value.")
        @Column(name = "purchase_price")
        private Double purchasePrice;

        @Column(name = "purchase_date")
        private Date purchase_date;

        @Column(name = "sales_tax_paid")
        private Double sales_tax_paid;

        @Column(name = "registration_date")
        private Date registration_date;

        @Column(name = "sale_status")
        private String sale_status;

        @Column(name = "sale_date")
        private Date sale_date;

        @Column(name = "sale_price")
        private Double sale_price;

        public VehiclesDB() { }

        public int getId_vehicles() {
            return id_vehicles;
        }

        public void setId_vehicles(int id_vehicles) {
            this.id_vehicles = id_vehicles;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Double getPurchasePrice() { return purchasePrice; }

        public void setPurchasePrice(Double purchasePrice) {
            this.purchasePrice = purchasePrice;
        }

        public Date getPurchase_date() {
            return purchase_date;
        }

        public void setPurchase_date(Date purchase_date) {
            this.purchase_date = purchase_date;
        }

        public Double getSales_tax_paid() {
            return sales_tax_paid;
        }

        public void setSales_tax_paid(Double sales_tax_paid) {
            this.sales_tax_paid = sales_tax_paid;
        }

        public Date getRegistration_date() {
            return registration_date;
        }

        public void setRegistration_date(Date registration_date) {
            this.registration_date = registration_date;
        }

        public String getSale_status() {
            return sale_status;
        }

        public void setSale_status(String sale_status) {
            this.sale_status = sale_status;
        }

        public Date getSale_date() {
            return sale_date;
        }

        public void setSale_date(Date sale_date) {
            this.sale_date = sale_date;
        }

        public Double getSale_price() {
            return sale_price;
        }

        public void setSale_price(Double sale_price) {
            this.sale_price = sale_price;
        }

        @Override
        public String toString() {
            return "Vehicles [id=" + id_vehicles + ", make=" + make + ", model=" + model + ", type=" + type + ", purchase_price=" + purchasePrice + ", purchase_date=" + purchase_date + ", sales_tax_paid=" + sales_tax_paid + ", registration_date=" + registration_date + ", sale_status=" + sale_status + ", sale_date=" + sale_date + ", sale_price=" + sale_price + "]";
        }
}
