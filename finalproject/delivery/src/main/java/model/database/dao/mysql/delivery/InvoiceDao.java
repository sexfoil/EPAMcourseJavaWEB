package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Invoice;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDao extends AbstractDAO {

    public InvoiceDao(Connection connection) {
        super(connection);
    }


    public void updateInvoiceStatus(int id, int statusId) {
        String query = buildUpdateInvoiceQuery(id, statusId);
        executeUpdate(query);
    }


    public void addInvoice(Invoice invoice) {
        String query = buildInsertInvoiceQuery(invoice);
        executeUpdate(query);
    }

    public Invoice getInvoiceById(int id) {
        String query = "select * from invoices where id=" + id + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return getInvoice(resultSet);
            }

        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }

        return null;
    }

    public List<Invoice> getAllUserInvoices(int userId) {
        String query = "select * from invoices where user_id=" + userId + ";";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Invoice> invoices = new ArrayList<>();
            while (resultSet.next()) {
                invoices.add(getInvoice(resultSet));
            }
            return invoices;

        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }

        return null;
    }

    public int getAmountInvoicesByStatus(int userId, int statusId) {
        String query = "select count(*) as amount from invoices where user_id= " + userId + " and status_id= " + statusId + ";";
        System.out.println(query);
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int i = resultSet.getInt("amount");
                System.out.println(i);
                return i;
            }


        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return 0;
    }

    private Invoice getInvoice(ResultSet resultSet) throws SQLException {

        return new Invoice(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getLong("cargo_id"),
                resultSet.getInt("cost"),
                resultSet.getTimestamp("date_time").toLocalDateTime(),
                resultSet.getInt("status_id")
        );

    }

    private void executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            // TODO
            e.printStackTrace();
        }
    }


    private String buildInsertInvoiceQuery(Invoice invoice) {

        StringBuilder query = new StringBuilder("insert into invoices ");
        query.append("(user_id, cargo_id, cost, date_time, status_id) values (");
        query.append(invoice.getUserId()).append(", ");
        query.append(invoice.getCargoId()).append(", ");
        query.append(invoice.getCost()).append(", '");
        query.append(invoice.getDateTime()).append("', ");
        query.append(invoice.getStatusId()).append(");");

        System.out.println(query.toString());
        return query.toString();
    }

    private String buildUpdateInvoiceQuery(int id, int statusId) {

        StringBuilder query = new StringBuilder("update invoices set ");
        query.append("status_id=").append(statusId).append(" where ");
        query.append("id=").append(id).append(";");

        System.out.println(query.toString());
        return query.toString();

    }


    @Override
    public List getAll() {
        return null;
    }
}
