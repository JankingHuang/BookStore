package com.asxb.bookstore.pojo;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable{

    private static final long serialVersionUID = 435841321473840065L;
    private Long fileId;
    private String realName;
    private String contentType;
    private Date updateDatetime;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", realName='" + realName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", updateDatetime=" + updateDatetime +
                '}';
    }
}
