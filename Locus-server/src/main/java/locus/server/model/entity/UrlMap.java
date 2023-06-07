package locus.server.model.entity;

import java.util.Date;

public class UrlMap {
    private Long id;

    private String shortUrl;

    private String longUrl;

    private String shortUrlDigest;

    private String longUrlDigest;

    private String compressionCode;

    private String description;

    private Byte urlStatus;

    private Date createTime;

    private Date editTime;

    private String creator;

    private String editor;

    private Byte deleted;

    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrlDigest() {
        return shortUrlDigest;
    }

    public void setShortUrlDigest(String shortUrlDigest) {
        this.shortUrlDigest = shortUrlDigest;
    }

    public String getLongUrlDigest() {
        return longUrlDigest;
    }

    public void setLongUrlDigest(String longUrlDigest) {
        this.longUrlDigest = longUrlDigest;
    }

    public String getCompressionCode() {
        return compressionCode;
    }

    public void setCompressionCode(String compressionCode) {
        this.compressionCode = compressionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getUrlStatus() {
        return urlStatus;
    }

    public void setUrlStatus(Byte urlStatus) {
        this.urlStatus = urlStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}