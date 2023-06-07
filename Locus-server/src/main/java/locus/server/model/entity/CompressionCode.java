package locus.server.model.entity;

import java.util.Date;

public class CompressionCode {
    private Long id;

    private String compressionCode;

    private Byte codeStatus;

    private String sequenceValue;

    private String strategy;

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

    public String getCompressionCode() {
        return compressionCode;
    }

    public void setCompressionCode(String compressionCode) {
        this.compressionCode = compressionCode;
    }

    public Byte getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(Byte codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(String sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
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