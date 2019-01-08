package model.database.dao.mysql.delivery;

import model.database.dao.AbstractDAO;
import model.entity.Invoice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDao extends AbstractDAO {

    public InvoiceDao(Connection connection) {
        super(connection);
    }


    public List<Invoice> getAllUserInvoices(int userId) {
        String query = "select * from addresses where user_id=" + userId + ";";
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

    private Invoice getInvoice(ResultSet resultSet) throws SQLException {

        return new Invoice(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getInt("cargo_id"),
                resultSet.getInt("cost"),
                resultSet.getTimestamp("date_time").toLocalDateTime(),
                resultSet.getInt("status_id")
        );

    }

    @Override
    public List getAll() {
        return null;
    }
}
