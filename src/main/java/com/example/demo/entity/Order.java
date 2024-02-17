package com.example.demo.entity;


public class Order {
    private Integer orderId;

    private Integer userId;

    public Integer bookid;

    private Integer booknum;
    
    private String status;

    private Double totalPrice;

    private String userName;

    public Double getTotalPrice(){
        return totalPrice;
    }
    public void setprice(Double tp){
        this.totalPrice=tp;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public String uesrName() {
        return userName;
    }
    public void setUesrName(String un) {
        this.userName = un;
    }
    public void setBookNum(Integer bn) {
        this.booknum = bn;
    }
     public Integer getbookid() {
        return bookid;
    }

    public void setbookid(Integer bookid){
        this.bookid=bookid;

    }
     public Integer getBooknum() {
        return booknum;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

   

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

   
    public String getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = "done";
    }

    @Override
    public String toString() {
        return "Order{" +
                " userId=" +userId + 
                ", bookid=" + bookid  +
                ", booknum=" +booknum +
                ", statuss='" + status  + '\''+
                ", userName='" + userName + '\''+
                ", orderId="+ orderId +
                ", price="+ totalPrice
                ;
    }


}