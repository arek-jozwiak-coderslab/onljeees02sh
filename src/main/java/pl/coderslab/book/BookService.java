package pl.coderslab.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final ServiceBookDao serviceBookDao;

    public BookService(ServiceBookDao serviceBookDao) {
        this.serviceBookDao = serviceBookDao;
    }

    public void save(ServiceBook serviceBook) {
        // create PZ
        serviceBookDao.save(serviceBook);
        //send email to newspetter
        // send info to marketing compamnny
    }

    public ServiceBook finfById(long id) {
        return serviceBookDao.findById(id);
    }
}
