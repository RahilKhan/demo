package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReportModel {

    private String pogName;
    private String pogNameFr;
    private String subHeading;
    private String disclaimer;
    private String date;
    private String pogId;
    private String side;

    private List<?> reportList;



}
