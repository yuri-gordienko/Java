package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.entity.Pupils;
import ua.com.alevel.service.JdbcService;
import ua.com.alevel.util.Color;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PupilsDaoImpl implements PupilsDao {

    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();
    private static final String CREATE_PUPIL = "insert into pupils values (default, ?, ?, ?, ?)";
    private static final String UPDATE_PUPIL = "update pupils set first_name = ?, last_name = ?, class = ?, email = ? where id = ?";
    private static final String DELETE_PUPIL = "delete from pupils where id = ?";
    private static final String FIND_PUPIL_BY_ID = "select * from pupils where id = ";
    private static final String FIND_ALL_PUPILS = "select * from pupils";
    private static final String EXIST_BY_FIRST_NAME_AND_LAST_NAME = "select count(*) as count_of_pupils from pupils where " +
            "first_name like ? or last_name like ?";

    @Override
    public void create(Pupils pupils) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_PUPIL)) {
            ps.setString(1, pupils.getFirstName());
            ps.setString(2, pupils.getLastName());
            ps.setInt(3, pupils.getClas());
            ps.setString(4, pupils.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Pupils pupils) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_PUPIL)) {
            ps.setString(1, pupils.getFirstName());
            ps.setString(2, pupils.getLastName());
            ps.setInt(3, pupils.getClas());
            ps.setString(4, pupils.getEmail());
            ps.setLong(5, pupils.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_PUPIL)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Pupils findById(Long id) {
        try(ResultSet rs = statement.executeQuery(FIND_PUPIL_BY_ID + id)) {
            rs.next();
            return convertResultSetToPupils(rs);
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Pupils> findAll() {
        List<Pupils> pupils = new ArrayList<>();
        try(ResultSet rs = statement.executeQuery(FIND_ALL_PUPILS)) {
            while (rs.next()) {
                pupils.add(convertResultSetToPupils(rs));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return pupils;
    }

    @Override
    public boolean existsByFirstNameOrLastName(String firstName, String lastName) {
        try(PreparedStatement ps = connection.prepareStatement(EXIST_BY_FIRST_NAME_AND_LAST_NAME)) {
            ps.setString(1, "%" + firstName + "%");
            ps.setString(2, "%" + lastName + "%");
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            long count = resultSet.getLong("count_of_pupils");
            Color.Colors color = null;
            System.out.printf(color.CYAN + "Кількість учнів за такими даними: " + String.valueOf(count) + ", статус учня - " + color.YELLOW);
            return count > 0;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return false;
    }

    private Pupils convertResultSetToPupils(ResultSet resultSet) throws SQLException {
        Pupils pupils = new Pupils();
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int clas = resultSet.getInt("class");
        String email = resultSet.getString("email");
        pupils.setId(id);
        pupils.setFirstName(firstName);
        pupils.setLastName(lastName);
        pupils.setClas(clas);
        pupils.setEmail(email);
        return pupils;
    }
}
