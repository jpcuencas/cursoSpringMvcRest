package com.cursosring.jpa.springdata.cursospring.entities;

import com.cursosring.jpa.springdata.cursospring.entities.interfaz.IBillingEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Product.
 */
//  extends JpaRepository<Product, Long>, JpaSpecificationExecutor ¿spring?
@Entity
@Table(name = "TSCR_PRODUCT")
public class Product implements IBillingEntity {
    
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
     * The Name.
     */
    String name;
    /**
     * The Price.
     */
    Double price;
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
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for property 'price'.
     *
     * @return Value for property 'price'.
     */
    public Double getPrice() {
        return price;
    }
    
    /**
     * Setter for property 'price'.
     *
     * @param price Value to set for property 'price'.
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    
    /**
     * @param o
     * @return
     */
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
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", audit=").append(audit);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
    //endregion
}
