package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name = "Tech", schema = "technology", catalog = "")
public class TechEntity {
    private String no;
    private String country;
    private String industry;
    private String cleanTechnology;
    private String productionStage;
    private String technologyOverview;
    private String effect;
    private String fields;
    private String highlights;
    private String typicalApplications;
    private String cost;
    private String stability;
    private String innovation;
    private String source;
    private String comment;

    @Id
    @Column(name = "NO", nullable = false, length = 255)
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Basic
    @Column(name = "Country", nullable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Industry", nullable = true, length = 255)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "CleanTechnology", nullable = true, length = 255)
    public String getCleanTechnology() {
        return cleanTechnology;
    }

    public void setCleanTechnology(String cleanTechnology) {
        this.cleanTechnology = cleanTechnology;
    }

    @Basic
    @Column(name = "ProductionStage", nullable = true, length = 255)
    public String getProductionStage() {
        return productionStage;
    }

    public void setProductionStage(String productionStage) {
        this.productionStage = productionStage;
    }

    @Basic
    @Column(name = "TechnologyOverview", nullable = true, length = -1)
    public String getTechnologyOverview() {
        return technologyOverview;
    }

    public void setTechnologyOverview(String technologyOverview) {
        this.technologyOverview = technologyOverview;
    }

    @Basic
    @Column(name = "Effect", nullable = true, length = -1)
    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Basic
    @Column(name = "Fields", nullable = true, length = -1)
    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    @Basic
    @Column(name = "Highlights", nullable = true, length = -1)
    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }

    @Basic
    @Column(name = "TypicalApplications", nullable = true, length = -1)
    public String getTypicalApplications() {
        return typicalApplications;
    }

    public void setTypicalApplications(String typicalApplications) {
        this.typicalApplications = typicalApplications;
    }

    @Basic
    @Column(name = "Cost", nullable = true, length = -1)
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "Stability", nullable = true, length = -1)
    public String getStability() {
        return stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    @Basic
    @Column(name = "Innovation", nullable = true, length = -1)
    public String getInnovation() {
        return innovation;
    }

    public void setInnovation(String innovation) {
        this.innovation = innovation;
    }

    @Basic
    @Column(name = "Source", nullable = true, length = -1)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "Comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TechEntity that = (TechEntity) o;
//
//        if (no != null ? !no.equals(that.no) : that.no != null) return false;
//        if (country != null ? !country.equals(that.country) : that.country != null) return false;
//        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
//        if (cleanTechnology != null ? !cleanTechnology.equals(that.cleanTechnology) : that.cleanTechnology != null)
//            return false;
//        if (productionStage != null ? !productionStage.equals(that.productionStage) : that.productionStage != null)
//            return false;
//        if (technologyOverview != null ? !technologyOverview.equals(that.technologyOverview) : that.technologyOverview != null)
//            return false;
//        if (effect != null ? !effect.equals(that.effect) : that.effect != null) return false;
//        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;
//        if (highlights != null ? !highlights.equals(that.highlights) : that.highlights != null) return false;
//        if (typicalApplications != null ? !typicalApplications.equals(that.typicalApplications) : that.typicalApplications != null)
//            return false;
//        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
//        if (stability != null ? !stability.equals(that.stability) : that.stability != null) return false;
//        if (innovation != null ? !innovation.equals(that.innovation) : that.innovation != null) return false;
//        if (source != null ? !source.equals(that.source) : that.source != null) return false;
//        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = no != null ? no.hashCode() : 0;
//        result = 31 * result + (country != null ? country.hashCode() : 0);
//        result = 31 * result + (industry != null ? industry.hashCode() : 0);
//        result = 31 * result + (cleanTechnology != null ? cleanTechnology.hashCode() : 0);
//        result = 31 * result + (productionStage != null ? productionStage.hashCode() : 0);
//        result = 31 * result + (technologyOverview != null ? technologyOverview.hashCode() : 0);
//        result = 31 * result + (effect != null ? effect.hashCode() : 0);
//        result = 31 * result + (fields != null ? fields.hashCode() : 0);
//        result = 31 * result + (highlights != null ? highlights.hashCode() : 0);
//        result = 31 * result + (typicalApplications != null ? typicalApplications.hashCode() : 0);
//        result = 31 * result + (cost != null ? cost.hashCode() : 0);
//        result = 31 * result + (stability != null ? stability.hashCode() : 0);
//        result = 31 * result + (innovation != null ? innovation.hashCode() : 0);
//        result = 31 * result + (source != null ? source.hashCode() : 0);
//        result = 31 * result + (comment != null ? comment.hashCode() : 0);
//        return result;
//    }
}
