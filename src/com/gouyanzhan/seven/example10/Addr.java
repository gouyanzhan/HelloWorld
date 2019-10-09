package com.gouyanzhan.seven.example10;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 21:36:19
 */
class Addr implements Cloneable {
    String country;
    String province;
    String city;
    Addr(String country , String province , String city){
        this.country = country;
        this.province = province;
        this.city = city;
    }
    @Override
    public Object clone(){
        Addr addr = null;
        try{
            addr = (Addr) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return addr;
    }


}
