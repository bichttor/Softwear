package com.softwears.Softwear.Payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
    List<Invoice> findByInvoiceId(int invoiceId);
}
