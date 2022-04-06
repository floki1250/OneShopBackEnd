package com.oneshopproject.oneshopproject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDAO {
    private static ProductDAO instance;

    Connection cn = ConnexionDB.getConnection();
    Statement st ;


    private ProductDAO() {

    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }

        return instance;
    }

    public List<Product> listAll() {
        List<Product> list = new ArrayList<>() ;
        Product product;
        String sql= "SELECT * FROM `product` ";
        try {
            st= cn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setUrl(rs.getString("url"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                list.add(product) ;
            }

            return list;

        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;

        }

    }

    public boolean add(Product product) {
       String sql = "INSERT INTO `product`(`name`, `description`, `url`, `price`) VALUES ('"+product.getName()+"','"+product.getDescription()+"','"+product.getUrl()+"',"+product.getPrice()+")" ;

        try {
            st =cn.createStatement();
            st.executeUpdate(sql);
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean add_User(User user) {
        String sql = "INSERT INTO `user`(`User`, `Password`) VALUES ('"+user.User+"','"+user.Password+"',)" ;
        try {
            st =cn.createStatement();
            st.executeUpdate(sql);
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public User getUser(String User,String Password){
        User user = null ;
        String sql = "SELECT `id`, `User`, `Password` FROM `user` WHERE User like '"+User+"' AND Password like '"+Password+"'" ;
        try {
            st= cn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUser(rs.getString("User"));
                user.setPassword(rs.getString("Password"));

            }
            assert user != null;

            return user;

        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;

        }

    }

    public Product get(int id) {
            Product product = null;
            String sql= "SELECT * FROM `product` WHERE id="+id;
            try {
                st= cn.createStatement();
                ResultSet rs =st.executeQuery(sql);
                while(rs.next()) {
                    product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setUrl(rs.getString("url"));
                    product.setDescription(rs.getString("description"));
                }
                assert product != null;

                return product;

            }catch(SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return null;

            }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM `product` WHERE id=" +id;

        try {
            st=cn.createStatement();
            st.executeUpdate(sql);
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return false;

    }

    public boolean update(Product product) {
        String sql = "UPDATE `product` SET `name`='"+product.getName()+"',`description`='"+product.getDescription()+"',`url`='"+product.getUrl()+"',`price`='"+product.getPrice()+"' WHERE `id`="+product.getId() ;
        try {
            st = cn.createStatement();
            if (st.executeUpdate(sql) == 1) {
                //System.out.println("update avec succes");
                return true;

            }
            System.out.println("id doesn't exist");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur update");
            return false;
        }
    }
}