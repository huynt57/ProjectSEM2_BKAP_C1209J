/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.MedicinesManager;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MedicineBean {
 private int medicineCode;
    private String medicineName;
    private int medicineTypeCode;
    private int supplierCode;
    private String termsOfUse;
    private int measure;
    private float pricePerUnit;

    private int avaiableAmount;
    private String registerNumber;
    private String Origin;
    private String used;
    private String useGuide;

    private String medicineTypeName;
    private String supplierName;
    private String measureName;

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(int medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
    }

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getAvaiableAmount() {
        return avaiableAmount;
    }

    public void setAvaiableAmount(int avaiableAmount) {
        this.avaiableAmount = avaiableAmount;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUseGuide() {
        return useGuide;
    }

    public void setUseGuide(String useGuide) {
        this.useGuide = useGuide;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public MedicineBean(int medicineCode, String medicineName, int medicineTypeCode, int supplierCode, String termsOfUse, int measure, float pricePerUnit, int avaiableAmount, String registerNumber, String Origin, String used, String useGuide, String medicineTypeName, String supplierName, String measureName) {
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.medicineTypeCode = medicineTypeCode;
        this.supplierCode = supplierCode;
        this.termsOfUse = termsOfUse;
        this.measure = measure;
        this.pricePerUnit = pricePerUnit;
        this.avaiableAmount = avaiableAmount;
        this.registerNumber = registerNumber;
        this.Origin = Origin;
        this.used = used;
        this.useGuide = useGuide;
        this.medicineTypeName = medicineTypeName;
        this.supplierName = supplierName;
        this.measureName = measureName;
    }

    public MedicineBean() {
    }
}
