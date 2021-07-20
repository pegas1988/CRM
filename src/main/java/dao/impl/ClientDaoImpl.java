package dao.impl;

import dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import entity.Client;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientDaoImpl implements ClientDao {

    private final DataSource dataSource;

    private static final String SELECT_FROM_CLIENT = "select * from client";
    private static final String SELECT_FROM_CLIENT_WHERE_FIRST_NAME_AND_LAST_NAME = "select * from client where first_name = ? and last_name = ?";
    private static final String INSERT_INTO_CLIENT = "insert into client (first_name, last_name, sex) values (?,?,?)";
    private static final String DELETE_FROM_CLIENT = "delete from client where last_name = ?";
    private static final String FIND_CLIENT_BY_ID = "select *from client where client_id = ?";


    public ClientDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//private static final String UPDATE_CLIENTS_Di_BY_NAME = "update client set last_name = 'changed' where first_name = ?";

//    @Override
////    public Client findById(int id) {
////        Client client = new Client();
////        try (Connection connection = dataSource.getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT_BY_ID);
////        ) {
////            preparedStatement.setInt(1, id);
////            ResultSet resultSet = preparedStatement.executeQuery();
////            while (resultSet.next()) {
////                client.setFirstName(resultSet.getString("first_name"));
////                client.setLastName(resultSet.getString("last_name"));
////                client.setDiagnoses(resultSet.getString("diagnoses"));
////                client.setSex(resultSet.getString("sex"));
////                client.setDateOfBirth(resultSet.getTimestamp("date_of_birth"));
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return client;
////    }


    public void create(Client client) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CLIENT, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            //preparedStatement.setDate(3, (Date) client.getDateOfBirth());
            preparedStatement.setString(3, client.getSex());
            //preparedStatement.setString(5, client.getDiagnoses());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setClientID((long) generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void updateDiagnose(Client client) {
        try (Connection connection = PostgresUtil.getConnetion();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_BY_NAME);
        ) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

//    @Override
//    public void delete(Client client) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CLIENT)
//        ) {
//            preparedStatement.setString(1, client.getLastName());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void deleteAll(Iterable<? extends Client> iterable) {

    }

    @Override
    public void deleteAll() {

    }

//    @Override
//    public List<Client> findAll() {
//        List<Client> clients = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(SELECT_FROM_CLIENT);
//        ) {
//            while (resultSet.next()) {
//                Client client = new Client();
//                client.setFirstName(resultSet.getString("first_name"));
//                client.setLastName(resultSet.getString("last_name"));
//                client.setDiagnoses(resultSet.getString("diagnoses"));
//                client.setSex(resultSet.getString("sex"));
//                client.setDateOfBirth(resultSet.getTimestamp("date_of_birth"));
//                clients.add(client);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clients;
//    }

    @Override
    public List<Client> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Client> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public <S extends Client> S save(S s) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Client> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Client client) {

    }

//    @Override
//    public void deleteAll(Iterable<? extends Client> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }

    @Override
    public List<Client> findAll() {
        return null;
    }


//    @Override
//    public List<Client> findByFirstNameAndSecondName(String name, String secondName) {
//        List<Client> clients = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT_WHERE_FIRST_NAME_AND_LAST_NAME);
//        ) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, secondName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Client client = new Client();
//                client.setFirstName(resultSet.getString("first_name"));
//                client.setLastName(resultSet.getString("last_name"));
//                client.setDiagnoses(resultSet.getString("diagnoses"));
//                client.setSex(resultSet.getString("sex"));
//                client.setDateOfBirth(resultSet.getTimestamp("date_of_birth"));
//                clients.add(client);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clients;
//    }
}

