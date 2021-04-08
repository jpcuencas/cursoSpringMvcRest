package com.cursosring.jpa.springdata.cursospring.entities;


import com.cursosring.jpa.springdata.cursospring.entities.interfaz.IBillingEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Bill.
 */
@Entity
@Table(name = "TSCR_BILL")
public class Bill implements IBillingEntity {
    
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
     * The Description.
     */
    String description;
    
    
    /**
     * The Observation.
     */
    String observation;
    
    /**
     * The Client.
     */
    @ManyToOne
    @JoinColumn(name = "fk_client")
    Client client;
    
    /**
     * The Lines.
     * bidireccional
     */
    @OneToMany(mappedBy = "bill", cascade = CascadeType.REMOVE)
    List<Line> lines;

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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }
    
    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
    /**
     * Gets observation.
     *
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }
    
    /**
     * Sets observation.
     *
     * @param observation the observation
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    /**
     * Gets lines.
     *
     * @return the lines
     */
    public List<Line> getLines() {
        return lines;
    }
    
    /**
     * Sets lines.
     *
     * @param lines the lines
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bill{");
        sb.append("id=").append(id);
        sb.append(", audit=").append(audit);
        sb.append(", description='").append(description).append('\'');
        sb.append(", observation='").append(observation).append('\'');
        sb.append(", client=").append(client);
        sb.append(", lines=").append(lines);
        sb.append('}');
        return sb.toString();
    }
//endregion
}
