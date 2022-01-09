package com.mycompany.artbalear.DataAcces;

import com.mycompany.artbalear.Models.Site;
import com.mycompany.artbalear.Models.User;
import com.mycompany.artbalear.NewUser.PasswordGenerator;
import com.mycompany.artbalear.NewUser.SendEmail;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class DataAcces {

    private Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataAcces.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return connection;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "SELECT * FROM dbo.[User]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("userMail"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        LocalDate.parse(resultSet.getString("birthDate")),
                        resultSet.getString("gender"),
                        resultSet.getBoolean("admin")
                );
                user.setId(resultSet.getInt("id"));
                users.add(user);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return users;
    }

    public int insertUser(User user) {

        String nuevaPassword = PasswordGenerator.getPassword();
        try (Connection connection = getConnection();) {

            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[User] (userMail, firstName, lastName, birthDate, gender, admin, password) "
                    + "VALUES (?,?,?,?,?,?,?)");
            insertStatement.setString(1, user.getUserMail());
            insertStatement.setString(2, user.getFirstName());
            insertStatement.setString(3, user.getLastName());
            insertStatement.setString(4, user.getBirthDate().toString());
            insertStatement.setString(5, user.getGender());
            insertStatement.setBoolean(6, user.isAdmin());
            insertStatement.setString(7, nuevaPassword);

            int result = insertStatement.executeUpdate();

            if (result > 0) {
                PreparedStatement selectStatement = connection.prepareStatement(
                        "SELECT MAX(id) AS newId FROM dbo.[User]");
                ResultSet resultSet = selectStatement.executeQuery();
                if (!resultSet.next()) {
                    return 0;
                }
                return resultSet.getInt("newId");
            }

            SendEmail.sendMessage(user.getUserMail(), nuevaPassword);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public ArrayList<Site> getSites() {
        ArrayList<Site> sites = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "SELECT * FROM dbo.[Site]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Site site = new Site(
                        resultSet.getString("register"),
                        resultSet.getString("name"),
                        resultSet.getString("municipi"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getInt("telephone"),
                        resultSet.getString("type"),
                        resultSet.getString("modalities"),
                        resultSet.getString("gestor"),
                        resultSet.getString("serveis")
                );
                sites.add(site);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return sites;
    }

    public int insertSite(Site site) {

        String nuevaPassword = PasswordGenerator.getPassword();
        try (Connection connection = getConnection();) {

            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[Site] (register, name, municipi, address, email, telephone, type, modalities, gestor, serveis) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            insertStatement.setString(1, site.getRegister());
            insertStatement.setString(2, site.getName());
            insertStatement.setString(3, site.getMunicipi());
            insertStatement.setString(4, site.getAddress());
            insertStatement.setString(5, site.getEmail());
            insertStatement.setInt(6, site.getTelephone());
            insertStatement.setString(7, site.getType());
            insertStatement.setString(8, site.getModalities());
            insertStatement.setString(9, site.getGestor());
            insertStatement.setString(10, site.getServeis());

            int result = insertStatement.executeUpdate();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
