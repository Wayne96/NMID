package cqupt.nmid.home.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
/**
 * 
 * @author MagicWolf
 * 项目模型
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)  
public class WorkModel {
    private int id;
    private String name;
    private String logo;
    private String version;
    private int size;
    private Long time;
    private String support;
    private String profile;
    private String utility;
    private String feature;
    private String illustration="[]";
    private String instruction;
    private String links;
    private int pv;
    private Integer isPass;
    
    
    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Long getTime() {
        return time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public String getSupport() {
        return support;
    }
    public void setSupport(String support) {
        this.support = support;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getUtility() {
        return utility;
    }
    public void setUtility(String utility) {
        this.utility = utility;
    }
    public String getFeature() {
        return feature;
    }
    public void setFeature(String feature) {
        this.feature = feature;
    }
    public String getIllustration() {
        return illustration;
    }
    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    public String getLinks() {
        return links;
    }
    public void setLinks(String links) {
        this.links = links;
    }
    public Integer getIsPass() {
        return isPass;
    }
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }
    @Override
    public String toString() {
        return "WorkModel [id=" + id + ", name=" + name + ", logo=" + logo
                + ", version=" + version + ", size=" + size + ", time=" + time
                + ", support=" + support + ", profile=" + profile
                + ", utility=" + utility + ", feature=" + feature
                + ", illustration=" + illustration + ", instruction="
                + instruction + ", links=" + links + ", pv=" + pv + ", isPass="
                + getIsPass() + "]";
    }
    
}
