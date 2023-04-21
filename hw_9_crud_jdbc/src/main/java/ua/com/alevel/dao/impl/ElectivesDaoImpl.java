package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.ElectivesDao;
import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.service.JdbcService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElectivesDaoImpl implements ElectivesDao {

    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();

    private static final String CREATE_ELECTIVE = "insert into electives values (default, ?)";
    private static final String UPDATE_ELECTIVE = "update electives set name = ? where id = ?";
    private static final String DELETE_ELECTIVE = "delete from electives where id = ?";
    private static final String FIND_ELECTIVE_BY_ID = "select * from electives where id = ?";
    private static final String FIND_ALL_ELECTIVES = "select * from electives";
    private static final String ATTACH_PUPILS_TO_ELECTIVE = "insert into relation_el_pup values (?, ?)";
    private static final String DETACH_PUPILS_TO_ELECTIVE = "delete from relation_el_pup where el_id = ? and pup_id = ?";
    private static final String FIND_ALL_ELECTIVES_STATISTICS_DESC = "select e.id, e.name, count(el_id) as pupils_count " +
            "from electives as e join relation_el_pup as rep on e.id = rep.el_id group by e.id order by pupils_count desc";
    private static final String FIND_ALL_ELECTIVES_STATISTICS_ASC = "select e.id, e.name, count(el_id) as pupils_count " +
            "from electives as e join relation_el_pup as rep on e.id = rep.el_id group by e.id order by pupils_count ask";

        @Override
    public void create(Electives electives) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_ELECTIVE)) {
            ps.setString(1, electives.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Electives electives) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_ELECTIVE)) {
            ps.setString(1, electives.getName());
            ps.setLong(2, electives.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_ELECTIVE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Electives findById(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(FIND_ELECTIVE_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return convertResultSetToElectives(rs);
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Electives> findAll() {
        List<Electives> electives = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(FIND_ALL_ELECTIVES)) {
            while (resultSet.next()) {
                electives.add(convertResultSetToElectives(resultSet));
            }
            return electives;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return electives;
    }

    @Override
    public void attachPupilsToElectives(Long electivesId, Long pupilsId) {
        try(PreparedStatement ps = connection.prepareStatement(ATTACH_PUPILS_TO_ELECTIVE)) {
            ps.setLong(1, electivesId);
            ps.setLong(2, pupilsId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void detachPupilsToElectives(Long electivesId, Long pupilsId) {
        try(PreparedStatement ps = connection.prepareStatement(DETACH_PUPILS_TO_ELECTIVE)) {
            ps.setLong(1, electivesId);
            ps.setLong(2, pupilsId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Collection<ElectivesDto> findElectivesStatistics() {
        List<ElectivesDto> electivesDto = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(FIND_ALL_ELECTIVES_STATISTICS_DESC)) {
            while (resultSet.next()) {
                electivesDto.add(convertResultSetToElectivesDto(resultSet));
            }
            return electivesDto;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return electivesDto;
    }

    private Electives convertResultSetToElectives(ResultSet resultSet) throws SQLException {
        Electives electives = new Electives();
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        electives.setId(id);
        electives.setName(name);
        return electives;
    }

    private ElectivesDto convertResultSetToElectivesDto(ResultSet resultSet) throws SQLException {
        ElectivesDto electivesDto = new ElectivesDto();
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Long count = resultSet.getLong("pupils_count");
        electivesDto.setId(id);
        electivesDto.setName(name);
        electivesDto.setPupilsCount(count);
        return electivesDto;
    }
}
