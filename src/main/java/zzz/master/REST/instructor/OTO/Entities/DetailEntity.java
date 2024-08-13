package zzz.master.REST.instructor.OTO.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Details")
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "canalName")
    private String canalName;

    @Column(name = "hobby")
    private String hobby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanalName() {
        return canalName;
    }

    public void setCanalName(String canalName) {
        this.canalName = canalName;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
