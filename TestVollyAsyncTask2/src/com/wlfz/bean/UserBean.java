package com.wlfz.bean;



import java.io.Serializable;



public class UserBean  implements Serializable{
    
    private String address;
    private int id; 
    private String plate_numbe; 
    private String locate_number;
    private String client;
    
    
     private String code;
      private String company;
    private String contact_number;
    private String contact_name;
    private int is_admin;
    
    private String token;
    private int  user_id;
    private String user_name;
    
    
    
    private String about_us;
    private String help_msg;
    
    private String request_interval;
    private String locate_interval;
   private String marker_size;
   
   
   
@Override
public String toString()
{
    return "UserBean [address=" + address + ", id=" + id + ", plate_numbe="
            + plate_numbe + ", locate_number=" + locate_number + ", client="
            + client + ", code=" + code + ", company=" + company
            + ", contact_number=" + contact_number + ", contact_name="
            + contact_name + ", is_admin=" + is_admin + ", token=" + token
            + ", user_id=" + user_id + ", user_name=" + user_name
            + ", about_us=" + about_us + ", help_msg=" + help_msg
            + ", locate_interval=" + locate_interval + ", marker_size="
            + marker_size + "]";
}
public String getAddress()
{
    return address;
}
public void setAddress(String address)
{
    this.address = address;
}



public String getRequest_interval()
{
    return request_interval;
}
public void setRequest_interval(String request_interval)
{
    this.request_interval = request_interval;
}
public int getId()
{
    return id;
}
public void setId(int id)
{
    this.id = id;
}
public String getPlate_numbe()
{
    return plate_numbe;
}
public void setPlate_numbe(String plate_numbe)
{
    this.plate_numbe = plate_numbe;
}
public String getLocate_number()
{
    return locate_number;
}
public void setLocate_number(String locate_number)
{
    this.locate_number = locate_number;
}
public String getClient()
{
    return client;
}
public void setClient(String client)
{
    this.client = client;
}
public String getCode()
{
    return code;
}
public void setCode(String code)
{
    this.code = code;
}
public String getCompany()
{
    return company;
}
public void setCompany(String company)
{
    this.company = company;
}
public String getContact_number()
{
    return contact_number;
}
public void setContact_number(String contact_number)
{
    this.contact_number = contact_number;
}
public String getContact_name()
{
    return contact_name;
}
public void setContact_name(String contact_name)
{
    this.contact_name = contact_name;
}
public int getIs_admin()
{
    return is_admin;
}
public void setIs_admin(int is_admin)
{
    this.is_admin = is_admin;
}
public String getToken()
{
    return token;
}
public void setToken(String token)
{
    this.token = token;
}
public int getUser_id()
{
    return user_id;
}
public void setUser_id(int user_id)
{
    this.user_id = user_id;
}
public String getUser_name()
{
    return user_name;
}
public void setUser_name(String user_name)
{
    this.user_name = user_name;
}
public String getAbout_us()
{
    return about_us;
}
public void setAbout_us(String about_us)
{
    this.about_us = about_us;
}
public String getHelp_msg()
{
    return help_msg;
}
public void setHelp_msg(String help_msg)
{
    this.help_msg = help_msg;
}
public String getLocate_interval()
{
    return locate_interval;
}
public void setLocate_interval(String locate_interval)
{
    this.locate_interval = locate_interval;
}
public String getMarker_size()
{
    return marker_size;
}
public void setMarker_size(String marker_size)
{
    this.marker_size = marker_size;
}
    
    
  
    
  
}
