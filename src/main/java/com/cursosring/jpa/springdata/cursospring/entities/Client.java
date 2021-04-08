package com.cursosring.jpa.springdata.cursospring.entities;


import com.cursosring.jpa.springdata.cursospring.entities.interfaz.IBillingEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Client.
 */
@Entity
@NamedQuery(name = "find.by.email", query = "SELECT c FROM Client c WHERE c.email = :email")
@Table(name = "TSCR_CLIENT")
public class Client implements IBillingEntity {
    
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
     * The Email.
     */
    String email;
    
    /**
     * The Surname.
     */
    String surname;
    
    /**
     * The Bills.
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    List<Bill> bills;
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
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Getter for property 'surname'.
     *
     * @return Value for property 'surname'.
     */
    public String getSurname() {
        return surname;
    }
    
    /**
     * Setter for property 'surname'.
     *
     * @param surname Value to set for property 'surname'.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    /**
     * Getter for property 'bills'.
     *
     * @return Value for property 'bills'.
     */
    public List<Bill> getBills() {
        return bills;
    }
    
    /**
     * Setter for property 'bills'.
     *
     * @param bills Value to set for property 'bills'.
     */
    public void setBills(List<Bill> bills) {
        this.bills = bills;
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
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("id=").append(id);
        sb.append(", audit=").append(audit);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", bills=").append(bills);
        sb.append('}');
        return sb.toString();
    }
    //endregion
}
