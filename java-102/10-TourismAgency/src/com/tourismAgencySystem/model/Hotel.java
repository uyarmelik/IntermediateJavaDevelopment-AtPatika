package com.tourismAgencySystem.model;

import com.tourismAgencySystem.helper.DBConnector;
import com.tourismAgencySystem.view.HotelAddGUI;
import com.tourismAgencySystem.view.HotelGUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String city;
    private String region;
    private String email;
    private String phone_num;
    private String star;
    private String boarding_house;
    private Array service_spec;

    public Hotel() {
    }

    public Hotel(int id, String name, String address, String email, String phone_num, String boarding_house, String city, String region, String star, Array service_spec) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.region = region;
        this.email = email;
        this.phone_num = phone_num;
        this.star = star;
        this.boarding_house = boarding_house;
        this.service_spec = service_spec;
    }


    public static Hotel getHotelByName(String hotelName){
        Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,hotelName);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj =  new Hotel(rs.getInt("id"),rs.getString("name"),rs.getString("address"),
                        rs.getString("email"),rs.getString("phone_num"),rs.getString("boarding_house"),
                        rs.getString("city"),rs.getString("region"), rs.getString("star"), rs.getArray("service_spec"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static Hotel getFetch(int id){
        Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE id = "+id;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                obj =  new Hotel(rs.getInt("id"),rs.getString("name"),rs.getString("address"),
                        rs.getString("email"),rs.getString("phone_num"),rs.getString("boarding_house"),
                        rs.getString("city"),rs.getString("region"), rs.getString("star"), rs.getArray("service_spec"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static boolean add(String name, String address, String email, String phone_num, String boarding_house, ArrayList<String> serviceSpec, String city, String region, String star) {
        String sql = "INSERT INTO public.hotel ( name,  address,  email,  phone_num,  boarding_house, city ,  region,  star,  service_spec) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Array array = DBConnector.getInstance().createArrayOf("VARCHAR", serviceSpec.toArray());
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(sql);
            pr.setString(1, name);
            pr.setString(2, address);
            pr.setString(3, email);
            pr.setString(4, phone_num);
            pr.setString(5, boarding_house);
            pr.setString(6, city);
            pr.setString(7, region);
            pr.setString(8, star);
            pr.setArray(9, array);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<Hotel> getList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        Hotel obj;
        String sql = "SELECT * FROM public.hotel";
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obj = new Hotel(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("email"),
                        rs.getString("phone_num"), rs.getString("boarding_house"),
                        rs.getString("city"), rs.getString("region"), rs.getString("star"),
                        rs.getArray("service_spec"));
                hotelList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotelList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getBoarding_house() {
        return boarding_house;
    }

    public void setBoarding_house(String boarding_house) {
        this.boarding_house = boarding_house;
    }

    public Array getService_spec() {
        return service_spec;
    }

    public void setService_spec(Array service_spec) {
        this.service_spec = service_spec;
    }
}
