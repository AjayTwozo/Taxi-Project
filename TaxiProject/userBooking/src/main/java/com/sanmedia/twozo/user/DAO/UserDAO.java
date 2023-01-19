package com.sanmedia.twozo.user.DAO;

import com.sanmedia.twozo.dbConnection.DBConnection;
import com.sanmedia.twozo.exceptions.LoginFailedException;
import com.sanmedia.twozo.exceptions.SignUpFailedException;
import com.sanmedia.twozo.user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Prompts the User services related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class UserDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * <p>
     *     Inserts {@link User} details in the respective table of our Database.
     * </p>
     *
     * @param user {@link User} holds all relevant personal details being unwrapped.
     * @return a user's ID being returned
     */
    public boolean signUp(final User user) {
        final String userInsertQuery =
                "INSERT INTO service_user (mobile_number, password, name, email) VALUES(?, ?, ?, ?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(userInsertQuery)) {
            preparedStatement.setString(1, user.getMobileNumber());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getEmailId());

            return preparedStatement.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new SignUpFailedException("Failed to Sign Up!");
        }
    }

    /**
     * <p>
     *     Checks User's details from the respective table of our Database.
     * </p>
     *
     *
     * @param user {@link User} holds all relevant personal details.
     * @return whether User's details matches.
     */
    public boolean login(final User user) {
        final String loginQuery = "SELECT name FROM service_user WHERE mobile_number = ? AND password = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
            preparedStatement.setString(1, user.getMobileNumber());
            preparedStatement.setString(2, user.getPassword());
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setName(resultSet.getString("name"));
            } else {
                throw new LoginFailedException("Incorrect info!");
            }
            return preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new LoginFailedException("Failed to login!");
        }
    }
}