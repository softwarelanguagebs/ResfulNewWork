package com.wlfz.bean;

import java.io.Serializable;

import android.R.integer;

public class Cargos implements Serializable
{
    int page_no;
    
    int page_size;
    
    String carriage;
    
    String company;
    
    String contact_name;
    
    String contact_number;
    
    String destination;
    
    String destination_code;
    
    String distance;
    
    String expired_time;
    
    int id;
    
    int trade_status;
    
   

    double latitude;
    
    double longitude;
    
    String memo;
    
    String origin;
    
    String origin_code;
    
    String publish_time;
    
    String short_title;
    
    String type;
    
    String user_code;
    
    int user_id;
    
    String volume;
    
    String weight;

    
    int  total;
    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getTrade_status()
    {
        return trade_status;
    }

    public void setTrade_status(int trade_status)
    {
        this.trade_status = trade_status;
    }
    public int getPage_no()
    {
        return page_no;
    }

    public void setPage_no(int page_no)
    {
        this.page_no = page_no;
    }

    public int getPage_size()
    {
        return page_size;
    }

    public void setPage_size(int page_size)
    {
        this.page_size = page_size;
    }

    public String getCarriage()
    {
        return carriage;
    }

    public void setCarriage(String carriage)
    {
        this.carriage = carriage;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getContact_name()
    {
        return contact_name;
    }

    public void setContact_name(String contact_name)
    {
        this.contact_name = contact_name;
    }

    public String getContact_number()
    {
        return contact_number;
    }

    public void setContact_number(String contact_number)
    {
        this.contact_number = contact_number;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getDestination_code()
    {
        return destination_code;
    }

    public void setDestination_code(String destination_code)
    {
        this.destination_code = destination_code;
    }

    public String getDistance()
    {
        return distance;
    }

    public void setDistance(String distance)
    {
        this.distance = distance;
    }

    public String getExpired_time()
    {
        return expired_time;
    }

    public void setExpired_time(String expired_time)
    {
        this.expired_time = expired_time;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getOrigin_code()
    {
        return origin_code;
    }

    public void setOrigin_code(String origin_code)
    {
        this.origin_code = origin_code;
    }

    public String getPublish_time()
    {
        return publish_time;
    }

    public void setPublish_time(String publish_time)
    {
        this.publish_time = publish_time;
    }

    public String getShort_title()
    {
        return short_title;
    }

    public void setShort_title(String short_title)
    {
        this.short_title = short_title;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getUser_code()
    {
        return user_code;
    }

    public void setUser_code(String user_code)
    {
        this.user_code = user_code;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getVolume()
    {
        return volume;
    }

    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Cargos [page_no=" + page_no + ", page_size=" + page_size
                + ", carriage=" + carriage + ", company=" + company
                + ", contact_name=" + contact_name + ", contact_number="
                + contact_number + ", destination=" + destination
                + ", destination_code=" + destination_code + ", distance="
                + distance + ", expired_time=" + expired_time + ", id=" + id
                + ", latitude=" + latitude + ", longitude=" + longitude
                + ", memo=" + memo + ", origin=" + origin + ", origin_code="
                + origin_code + ", publish_time=" + publish_time
                + ", short_title=" + short_title + ", type=" + type
                + ", user_code=" + user_code + ", user_id=" + user_id
                + ", volume=" + volume + ", weight=" + weight + ", total="
                + total + "]";
    }

  
    
    
}
