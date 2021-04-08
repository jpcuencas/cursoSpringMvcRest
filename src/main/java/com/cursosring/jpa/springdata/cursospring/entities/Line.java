package com.cursosring.jpa.springdata.cursospring.entities;


import com.cursosring.jpa.springdata.cursospring.entities.interfaz.IBillingEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Line.
 */
@Entity
@Table(name = "TSCR_LINE")
public class Line implements IBillingEntity {
    
    //region Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * The Audit.
     */
    @Embedded
    Audit audit;
    /**
     * The Quantity.
     */
    Integer quantity;
    /**
     * The Bill.
     * bidireccional
     */
    @ManyToOne
    Bill bill;
    /**
     * The Product.
     * unidireccional
     */
    @ManyToOne
    @JoinColumn(name = "fk_product")
    Product product;
//endregion
    
    //region Metodos
    public Long getId() {
        return id;
    }
    
    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets audit.
     *
     * @return the audit
     */
    public Audit getAudit() {
        return audit;
    }
    
    /**
     * Sets audit.
     *
     * @param audit the audit
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    
    /**
     * Getter for property 'quantity'.
     *
     * @return Value for property 'quantity'.
     */
    public Integer getQuantity() {
        return quantity;
    }
    
    /**
     * Setter for property 'quantity'.
     *
     * @param quantity Value to set for property 'quantity'.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Getter for property 'bill'.
     *
     * @return Value for property 'bill'.
     */
    public Bill getBill() {
        return bill;
    }
    
    /**
     * Setter for property 'bill'.
     *
     * @param bill Value to set for property 'bill'.
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
    /**
     * Getter for property 'product'.
     *
     * @return Value for property 'product'.
     */
    public Product getProduct() {
        return product;
    }
    
    /**
     * Setter for property 'product'.
     *
     * @param product Value to set for property 'product'.
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.getId());
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Line{");
        sb.append("id=").append(id);
        sb.append(", audit=").append(audit);
        sb.append(", quantity=").append(quantity);
        sb.append(", bill=").append(bill);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
//endregion
}
