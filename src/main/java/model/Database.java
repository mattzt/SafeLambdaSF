package model;

import java.sql.*;

public class Database {
    Connection dataBaseConection;


    public Database() throws SQLException {
        String urlData = "jdbc:mysql://localhost/lambda_sf";
        dataBaseConection = DriverManager.getConnection(urlData, "root", "");
    }

    public void newAccount(String inputUsername, String inputPasword) {
        try {
            PreparedStatement pst = dataBaseConection.prepareStatement("insert into users values(?,?)");
            pst.setString(1,inputUsername);
            pst.setString(2,inputPasword);
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAccount(String inputUsername) {
        try {
            PreparedStatement pst = dataBaseConection.prepareStatement("delete from users where username=?");
            pst.setString(1,inputUsername);
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


/**Test method*/
    public int testNumberOfAccounts() {
        try {
            Statement pst = dataBaseConection.createStatement();
            ResultSet resultSet = pst.executeQuery("select count(*) from users");
            resultSet.next();
            int resultado = resultSet.getInt(1);
            resultSet.close();
            return resultado;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
}
