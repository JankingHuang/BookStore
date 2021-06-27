package com.asxb.bookstore.pojo;
/**
 * @author DingJiang
 * @date 2021/6/27 17:43
 */
import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = 435841321473840065L;

    private Long bookId;
    private String bookName;
    private String NamePinyin;
    private Long categoryId;
    private String bookAuthor;
    private Float bookPrice;
    private String bookImage;
    private String publishing;
    private String bookDesc;
    private Integer bookState;
    private Date deployDatetime;
    private Integer salesVolume;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNamePinyin() {
        return NamePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        NamePinyin = namePinyin;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Integer getBookState() {
        return bookState;
    }

    public void setBookState(Integer bookState) {
        this.bookState = bookState;
    }

    public Date getDeployDatetime() {
        return deployDatetime;
    }

    public void setDeployDatetime(Date deployDatetime) {
        this.deployDatetime = deployDatetime;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", NamePinyin='" + NamePinyin + '\'' +
                ", categoryId=" + categoryId +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImage='" + bookImage + '\'' +
                ", publishing='" + publishing + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                ", bookState=" + bookState +
                ", deployDatetime=" + deployDatetime +
                ", salesVolume=" + salesVolume +
                '}';
    }
}
