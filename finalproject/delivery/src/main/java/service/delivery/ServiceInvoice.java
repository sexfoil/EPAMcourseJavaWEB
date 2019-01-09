package service.delivery;

import model.database.dao.mysql.delivery.InvoiceDao;
import model.entity.Invoice;
import service.AbstractService;
import utility.DeliveryNames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceInvoice extends AbstractService {

    private InvoiceDao dao;

    public ServiceInvoice() {
        super(DeliveryNames.INVOICES);
        dao = (InvoiceDao) abstractDAO;
    }

    public void saveInvoice(int userId, long cargoId, int cost, LocalDateTime dateTime, int statusId) {
        Invoice invoice = new Invoice(-1, userId, cargoId, cost, dateTime, statusId);
        dao.addInvoice(invoice);
    }

    public int getAmountInvoicesByStatus(int userId, int statusId) {
        return dao.getAmountInvoicesByStatus(userId, statusId);
    }

    public List<Invoice> getAllUserInvoices(int userId) {
        return dao.getAllUserInvoices(userId);
    }

    public Invoice getInvoiceById(int id) {
        return dao.getInvoiceById(id);
    }

    public void updateStatus(int id, int statusId) {
        dao.updateInvoiceStatus(id, statusId);
    }
}
