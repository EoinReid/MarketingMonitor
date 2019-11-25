/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author vaugh
 */
public class Statistics {
    private double maxCost;
    private double minCost;
    private double mean;
    private double median;

    public Statistics(double maxCost, double minCost, double mean, double median) {
        this.maxCost = maxCost;
        this.minCost = minCost;
        this.mean = mean;
        this.median = median;
    }

    public Statistics() {
    }

    public double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(double maxCost) {
        this.maxCost = maxCost;
    }

    public double getMinCost() {
        return minCost;
    }

    public void setMinCost(double minCost) {
        this.minCost = minCost;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    @Override
    public String toString() {
        return "Statistics{" + "maxCost=" + maxCost + ", minCost=" + minCost + ", mean=" + mean + ", median=" + median + '}';
    }
    
    
}


