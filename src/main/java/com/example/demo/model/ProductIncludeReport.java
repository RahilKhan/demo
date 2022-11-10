/**
 * Model class for Product Included Report
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductIncludeReport {
    private int segment;
    private String sku;
    private int fineline;
    private int bincap;
    private int facings;
    private int moq;
    private String description;
    private String sls;
    private int sales;
    private double wos;
    private String details;

}
