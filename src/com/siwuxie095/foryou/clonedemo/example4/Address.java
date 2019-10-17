package com.siwuxie095.foryou.clonedemo.example4;

/**
 * @author Jiajing Li
 * @date 2019-10-09 09:15:48
 */
class Address implements Cloneable {

    private String country;

    private String province;

    private String city;

    public Address(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public Address clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}
