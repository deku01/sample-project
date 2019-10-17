/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dharmendra Kushwaha
 */
@Entity
@Table(name = "purchase_details", catalog = "sampleproject", schema = "")
@NamedQueries({
    @NamedQuery(name = "PurchaseDetails.findAll", query = "SELECT p FROM PurchaseDetails p")
    , @NamedQuery(name = "PurchaseDetails.findByBillNo", query = "SELECT p FROM PurchaseDetails p WHERE p.billNo = :billNo")
    , @NamedQuery(name = "PurchaseDetails.findByBillDate", query = "SELECT p FROM PurchaseDetails p WHERE p.billDate = :billDate")
    , @NamedQuery(name = "PurchaseDetails.findByTranscationType", query = "SELECT p FROM PurchaseDetails p WHERE p.transcationType = :transcationType")
    , @NamedQuery(name = "PurchaseDetails.findByDueDate", query = "SELECT p FROM PurchaseDetails p WHERE p.dueDate = :dueDate")
    , @NamedQuery(name = "PurchaseDetails.findBySupplier", query = "SELECT p FROM PurchaseDetails p WHERE p.supplier = :supplier")})
public class PurchaseDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "bill_date")
    private String billDate;
    @Column(name = "transcation_type")
    private String transcationType;
    @Column(name = "due_date")
    private String dueDate;
    @Column(name = "supplier")
    private String supplier;

    public PurchaseDetails() {
    }

    public PurchaseDetails(String billNo) {
        this.billNo = billNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        String oldBillNo = this.billNo;
        this.billNo = billNo;
        changeSupport.firePropertyChange("billNo", oldBillNo, billNo);
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        String oldBillDate = this.billDate;
        this.billDate = billDate;
        changeSupport.firePropertyChange("billDate", oldBillDate, billDate);
    }

    public String getTranscationType() {
        return transcationType;
    }

    public void setTranscationType(String transcationType) {
        String oldTranscationType = this.transcationType;
        this.transcationType = transcationType;
        changeSupport.firePropertyChange("transcationType", oldTranscationType, transcationType);
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        String oldDueDate = this.dueDate;
        this.dueDate = dueDate;
        changeSupport.firePropertyChange("dueDate", oldDueDate, dueDate);
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        String oldSupplier = this.supplier;
        this.supplier = supplier;
        changeSupport.firePropertyChange("supplier", oldSupplier, supplier);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billNo != null ? billNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseDetails)) {
            return false;
        }
        PurchaseDetails other = (PurchaseDetails) object;
        if ((this.billNo == null && other.billNo != null) || (this.billNo != null && !this.billNo.equals(other.billNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ui.PurchaseDetails[ billNo=" + billNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
