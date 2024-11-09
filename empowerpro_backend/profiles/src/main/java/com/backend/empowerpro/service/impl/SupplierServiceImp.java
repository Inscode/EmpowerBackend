package com.backend.empowerpro.service.impl;



import com.backend.empowerpro.dto.suppliers.SuppliersCreationDto;
import com.backend.empowerpro.dto.suppliers.SuppliersDto;
import com.backend.empowerpro.entity.Suppliers;
import com.backend.empowerpro.repository.SupplierRepo;
import com.backend.empowerpro.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class SupplierServiceImp implements SupplierService {
    private final SupplierRepo supplierRepo;
    private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);


    // get all suppliers
    @Override
    public List<SuppliersDto> getAllSuppliers() {
        List<SuppliersDto> result = new ArrayList<>();
        try {
            List<Suppliers> allSuppliersEntities = supplierRepo.findAll();
            for(Suppliers user : allSuppliersEntities){
                SuppliersDto suppliersDto = new SuppliersDto(
                        user.getId(),
                        user.getSupplierName(),
                        user.getContactEmail(),
                        user.getContactPhoneNo(),
                        user.getSupplierDescription() ,

                        user.getCreatedAt(),
                        user.getUpdatedAt()

                        );
                result.add(suppliersDto);
            }
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while fetching suppliers", e);
        }
        return result;
    }

    // create suppliers

    @Override
    public String createSuppliers(SuppliersCreationDto suppliersCreationDto) {

        Suppliers newSupplier = new Suppliers();

        try{
            newSupplier.setSupplierName(suppliersCreationDto.getSupplierName());
            newSupplier.setContactEmail(suppliersCreationDto.getContactEmail());
            newSupplier.setContactPhoneNo(suppliersCreationDto.getContactPhoneNo());
            newSupplier.setSupplierDescription(suppliersCreationDto.getSupplierDescription());
            supplierRepo.save(newSupplier);
            return "Supplier created successfully with SupplierID: " ;

    } catch (Exception e) {
        throw new RuntimeException("An unexpected error occurred while creating supplier", e);
    }

    }

    // get one supplier
    @Override
    public SuppliersDto getOneSupplier(Long id) {
        try {
            Suppliers supplier = supplierRepo.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
            return new SuppliersDto(
                    supplier.getId(),
                    supplier.getSupplierName(),
                    supplier.getContactEmail(),
                    supplier.getContactPhoneNo(),
                    supplier.getSupplierDescription(),
                    supplier.getCreatedAt(),
                    supplier.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while fetching the supplier", e);
        }
    }

    @Override
    public SuppliersDto updateSuppliers(Long id, SuppliersCreationDto suppliersCreationDto) {
        try {
            Suppliers existingSupplier = supplierRepo.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
            existingSupplier.setSupplierName(suppliersCreationDto.getSupplierName());
            existingSupplier.setContactEmail(suppliersCreationDto.getContactEmail());
            existingSupplier.setContactPhoneNo(suppliersCreationDto.getContactPhoneNo());
            existingSupplier.setSupplierDescription(suppliersCreationDto.getSupplierDescription());
            Suppliers updatedSupplier = supplierRepo.save(existingSupplier);
            return new SuppliersDto(
                    updatedSupplier.getId(),
                    updatedSupplier.getSupplierName(),
                    updatedSupplier.getContactEmail(),
                    updatedSupplier.getContactPhoneNo(),
                    updatedSupplier.getSupplierDescription(),
                    updatedSupplier.getCreatedAt(),
                    updatedSupplier.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while updating the supplier", e);
        }
    }

    // delete suppliers
    @Override
    public String deleteSuppliers(Long id) {
        try {
            Suppliers existingSupplier = supplierRepo.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
            supplierRepo.delete(existingSupplier);
            return "Supplier deleted successfully with SupplierID: " + id;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while deleting the supplier", e);
        }
    }

}
