package service.delivery;

import model.database.dao.mysql.delivery.InvoiceDao;
import service.AbstractService;
import utility.DeliveryNames;

public class ServiceInvoice extends AbstractService {

    private InvoiceDao dao;

    public ServiceInvoice() {
        super(DeliveryNames.INVOICES);
        dao = (InvoiceDao) abstractDAO;
    }
}
