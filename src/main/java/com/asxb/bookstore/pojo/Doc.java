package com.asxb.bookstore.pojo;

import java.io.Serializable;

public class Doc implements Serializable{

    private static final long serialVersionUID = 435841321473840065L;

    private Long Id;
    private String fileName;
    private String mime;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "Id=" + Id +
                ", fileName='" + fileName + '\'' +
                ", mime='" + mime + '\'' +
                '}';
    }
}
