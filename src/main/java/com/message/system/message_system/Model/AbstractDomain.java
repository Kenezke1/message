package com.message.system.message_system.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class AbstractDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public AbstractDomain() {
    }

    //Getter

    public Integer getId() {
        return id;
    }

    //Setter


    public void setId(Integer id) {
        this.id = id;
    }

    //Methods

    @Override
    public String toString() {
        return "AbstractDomain{" +
                "id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDomain that = (AbstractDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
