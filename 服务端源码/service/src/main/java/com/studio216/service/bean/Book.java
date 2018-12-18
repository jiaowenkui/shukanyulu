package com.studio216.service.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Book implements Serializable {
    private String book1DCode;//图书条形码code
    private String bookISBN;//图书ISBN
    private String bookname;//图书名称
    private String bookType;//图书类别
    private String bookAuthors;//图书作者
    private String bookLanguage;//图书语言
    private String bookContent;//图书内容缩略
    private String bookPublic;//图书出版社
    private String bookEdition;//图书班版次
    private Timestamp bookPublicdate;//图书出版日期
    private String bookSize;//图书纸张大小
    private String bookPrintedSheets;//图书印张
    private String bookNumber;//图书字数
    private String bookImpression;//图书印次
    private String bookPrintedNumber;//图书印数
    private Double bookprice;//图书价格
    private String bookAappurtenances;//图书附带物
    private String bookIsBorrow;//图书是否借出
    private String bookplace;//图书位置
    private String bookImage;

    public Book() {
        super();
    }

    
	public Book(String book1dCode, String bookISBN, String bookname,
			String bookType, String bookAuthors, String bookLanguage,
			String bookContent, String bookPublic, String bookEdition,
			Timestamp bookPublicdate, String bookSize,
			String bookPrintedSheets, String bookNumber, String bookImpression,
			String bookPrintedNumber, Double bookprice,
			String bookAappurtenances, String bookIsBorrow, String bookplace,
			String bookImage) {
		super();
		book1DCode = book1dCode;
		this.bookISBN = bookISBN;
		this.bookname = bookname;
		this.bookType = bookType;
		this.bookAuthors = bookAuthors;
		this.bookLanguage = bookLanguage;
		this.bookContent = bookContent;
		this.bookPublic = bookPublic;
		this.bookEdition = bookEdition;
		this.bookPublicdate = bookPublicdate;
		this.bookSize = bookSize;
		this.bookPrintedSheets = bookPrintedSheets;
		this.bookNumber = bookNumber;
		this.bookImpression = bookImpression;
		this.bookPrintedNumber = bookPrintedNumber;
		this.bookprice = bookprice;
		this.bookAappurtenances = bookAappurtenances;
		this.bookIsBorrow = bookIsBorrow;
		this.bookplace = bookplace;
		this.bookImage = bookImage;
	}


	public String getBook1DCode() {
		return book1DCode;
	}


	public void setBook1DCode(String book1dCode) {
		book1DCode = book1dCode;
	}


	public String getBookISBN() {
		return bookISBN;
	}


	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getBookType() {
		return bookType;
	}


	public void setBookType(String bookType) {
		this.bookType = bookType;
	}


	public String getBookAuthors() {
		return bookAuthors;
	}


	public void setBookAuthors(String bookAuthors) {
		this.bookAuthors = bookAuthors;
	}


	public String getBookLanguage() {
		return bookLanguage;
	}


	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}


	public String getBookContent() {
		return bookContent;
	}


	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}


	public String getBookPublic() {
		return bookPublic;
	}


	public void setBookPublic(String bookPublic) {
		this.bookPublic = bookPublic;
	}


	public String getBookEdition() {
		return bookEdition;
	}


	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}


	public Timestamp getBookPublicdate() {
		return bookPublicdate;
	}


	public void setBookPublicdate(Timestamp bookPublicdate) {
		this.bookPublicdate = bookPublicdate;
	}


	public String getBookSize() {
		return bookSize;
	}


	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}


	public String getBookPrintedSheets() {
		return bookPrintedSheets;
	}


	public void setBookPrintedSheets(String bookPrintedSheets) {
		this.bookPrintedSheets = bookPrintedSheets;
	}


	public String getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getBookImpression() {
		return bookImpression;
	}


	public void setBookImpression(String bookImpression) {
		this.bookImpression = bookImpression;
	}


	public String getBookPrintedNumber() {
		return bookPrintedNumber;
	}


	public void setBookPrintedNumber(String bookPrintedNumber) {
		this.bookPrintedNumber = bookPrintedNumber;
	}


	public Double getBookprice() {
		return bookprice;
	}


	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}


	public String getBookAappurtenances() {
		return bookAappurtenances;
	}


	public void setBookAappurtenances(String bookAappurtenances) {
		this.bookAappurtenances = bookAappurtenances;
	}


	public String getBookIsBorrow() {
		return bookIsBorrow;
	}


	public void setBookIsBorrow(String bookIsBorrow) {
		this.bookIsBorrow = bookIsBorrow;
	}


	public String getBookplace() {
		return bookplace;
	}


	public void setBookplace(String bookplace) {
		this.bookplace = bookplace;
	}


	public String getBookImage() {
		return bookImage;
	}


	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}


	@Override
    public String toString() {
        return "类别:   书籍类\n" +
                "条形码ID:   " + book1DCode + "\n" +
                "图书ISBN:   " + bookISBN + "\n" +
                "图书名称:   " + bookname + "\n" +
                "图书类别:   " + bookType + "\n" +
                "图书作者:   " + bookAuthors + "\n" +
                "图书语言:   " + bookLanguage + "\n" +
                "图书主要内容:   " + bookContent + "\n" +
                "图书出版社:   " + bookPublic + "\n" +
                "图书版次:   " + bookEdition + "\n" +
                "图书出版日期:   " + bookPublicdate + "\n" +
                "图书纸张大小:   " + bookSize + "\n" +
                "图书印张:   " + bookPrintedSheets + "\n" +
                "图书字数:   " + bookNumber + "\n" +
                "图书印次:   " + bookImpression + "\n" +
                "图书印数:   " + bookPrintedNumber + "\n" +
                "图书价格:   " + bookprice + "\n" +
                "图书附带:   " + bookAappurtenances + "\n" +
                "图书是否借出:   " + bookIsBorrow + "\n" +
                "图书位置" + bookplace;
    }
}
