package com.retroHIFI.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.DetalleOrden;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer>{

}
