package com.softwears.Softwear.Payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository repo;

    public List<Invoice> getInvoice() {
        return repo.findAll();
    }
}
