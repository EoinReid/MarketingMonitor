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
    private int viewCount;
    private String county;

    //Need to add photo variable (Blob or as possible byte)

    public Ad(Enum type, String title, double price, String section, String description, int id, Enum currency, String subSection, Timestamp time, int viewCount, String county) {
        this.type = type;
        this.title = title;
        this.price = price;
        this.section = section;
        this.description = description;
        this.id = id;
        this.currency = currency;
        this.subSection = subSection;
        this.time = time;
        this.viewCount = viewCount;
        this.county = county;
    }

    public Ad() {
    }

    public Ad(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Ad(String title, double price, int viewCount) {
        this.title = title;
        this.price = price;
        this.viewCount = viewCount;
    }

    public Ad(String title, double price, int viewCount, String county) {
        this.title = title;
        this.price = price;
        this.viewCount = viewCount;
        this.county = county;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrency(Enum currency) {
        this.currency = currency;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Enum getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getSection() {
        return section;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Enum getCurrency() {
        return currency;
    }

    public String getSubSection() {
        return subSection;
    }

    public Timestamp getTime() {
        return time;
    }

    public int getViewCount() {
        return viewCount;
    }

    public String getCounty() {
        return county;
    }

    @Override
    public String toString() {
        return "Ad{" + "type=" + type + ", title=" + title + ", price=" + price + ", section=" + section + ", description=" + description + ", id=" + id + ", currency=" + currency + ", subSection=" + subSection + ", time=" + time + ", viewCount=" + viewCount + ", county=" + county + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.section);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.currency);
        hash = 59 * hash + Objects.hashCode(this.subSection);
        hash = 59 * hash + Objects.hashCode(this.time);
        hash = 59 * hash + this.viewCount;
        hash = 59 * hash + Objects.hashCode(this.county);
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
        if (this.viewCount != other.viewCount) {
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
        if (!Objects.equals(this.county, other.county)) {
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

    

}

