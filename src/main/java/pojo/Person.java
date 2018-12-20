package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(nullable = false)
    private long name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private  List<Contact> contacts = new ArrayList<>();



    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
