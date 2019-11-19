/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author tiarn
 */
public class Ad {

    private Enum type;
    private String title;
    private double price;
    private String section;
    private String description;
    private int id;
    private Enum currency;
    private String subSection;
    private Timestamp time;

    //Need to add photo variable (Blob or as possible byte)

    public Ad(Enum type, String title, double price, String section, String description, int id, Enum currency, String subSection, Timestamp time){

   

        this.type = type;
        this.title = title;
        this.price = price;
        this.section = section;
        this.description = description;
        this.id = id;
        this.currency = currency;
        this.subSection = subSection;
        this.time = time;
    }
    
    public Ad() 
    {
        

    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enum getCurrency() {
        return currency;
    }

    public void setCurrency(Enum currency) {
        this.currency = currency;
    }

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.section);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.currency);
        hash = 53 * hash + Objects.hashCode(this.subSection);
        hash = 53 * hash + Objects.hashCode(this.time);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ad other = (Ad) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.section, other.section)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subSection, other.subSection)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.currency != other.currency) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ad{" + "type=" + type + ", title=" + title + ", price=" + price + ", section=" + section + ", description=" + description + ", id=" + id + ", currency=" + currency + ", subSection=" + subSection + ", time=" + time + '}';
    }

}

