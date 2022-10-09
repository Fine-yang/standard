package com.example.demo.entity;

public class StandardEng {
    private int detailEng_id;
    private String industry;
    private String region;
    private String standard;
    private String number;
    private String effectiveness;
    private String abstracts;
    private String link;
    private int scope;
    private int year;
    private String filename;
    private String filedir;

    public int getDetailEng_id() {
        return detailEng_id;
    }

    public void setDetailEng_id(int detailEng_id) {
        this.detailEng_id = detailEng_id;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFilename() {
        return  filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiledir() {
        return  filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }
}
