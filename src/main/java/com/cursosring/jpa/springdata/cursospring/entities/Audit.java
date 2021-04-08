package com.cursosring.jpa.springdata.cursospring.entities;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * The type Audit.
 */
@Embeddable
public class Audit {

//region Atributos
    /**
     * The Update on.
     */
    LocalDateTime updateOn;
    /**
     * The Create on.
     */
    LocalDateTime createOn;
//endregion


//region Metodos
    
    
    /**
     * Getter for property 'updateOn'.
     *
     * @return Value for property 'updateOn'.
     */
    public LocalDateTime getUpdateOn() {
        return updateOn;
    }
    
    /**
     * Setter for property 'updateOn'.
     *
     * @param updateOn Value to set for property 'updateOn'.
     */
    public void setUpdateOn(LocalDateTime updateOn) {
        this.updateOn = updateOn;
    }
    
    /**
     * Getter for property 'createOn'.
     *
     * @return Value for property 'createOn'.
     */
    public LocalDateTime getCreateOn() {
        return createOn;
    }
    
    /**
     * Setter for property 'createOn'.
     *
     * @param createOn Value to set for property 'createOn'.
     */
    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Audit{");
        sb.append("updateOn=").append(updateOn);
        sb.append(", createOn=").append(createOn);
        sb.append('}');
        return sb.toString();
    }
//endregion
}
