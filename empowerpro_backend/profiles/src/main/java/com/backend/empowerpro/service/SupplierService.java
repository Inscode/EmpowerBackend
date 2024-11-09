package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.suppliers.SuppliersCreationDto;
import com.backend.empowerpro.dto.suppliers.SuppliersDto;


import java.util.List;

public interface SupplierService{
public List<SuppliersDto> getAllSuppliers();
public String createSuppliers(SuppliersCreationDto suppliersCreationDto);
public SuppliersDto getOneSupplier(Long id);
public SuppliersDto updateSuppliers(Long id,SuppliersCreationDto suppliersCreationDto);
public String deleteSuppliers(Long id);
}
