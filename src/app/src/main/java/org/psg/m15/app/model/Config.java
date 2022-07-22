package org.psg.m15.app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_config")
public class Config implements Serializable {
    private static final long serialVersionUID = 9038228626276209369L;

    //ATTRIBUTES
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "max_passwd")
    private Integer maxPassword;

    @Column(name = "intents", nullable = false)
    private int intents;

    @Column(name = "assumpte_mail", length = 20, nullable = false)
    private String assumpteMail;

    @Column(name = "cos_mail", length = 100, nullable = false)
    private String cosMail;

    //GETTERS & SETTERS


    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getMaxPassword() {
        return maxPassword;
    }

    public void setMaxPassword(Integer maxPassword) {
        this.maxPassword = maxPassword;
    }

    public int getIntents() {return intents;}

    public void setIntents(int intents) {this.intents = intents;}

    public String getAssumpteMail() {return assumpteMail;}

    public void setAssumpteMail(String assumpteMail) {this.assumpteMail = assumpteMail;}

    public String getCosMail() {return cosMail;}

    public void setCosMail(String cosMail) {this.cosMail = cosMail;}
}
