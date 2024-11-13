package com.softwears.Softwear.Payments;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
    List<Invoice> findByInvoiceId(int invoiceId);
}
