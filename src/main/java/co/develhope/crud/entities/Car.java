package co.develhope.crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String nomeModello;
    private String tipo;

    public Car() {
    }

    public Car(long Id, String nomeModello, String tipo) {
        this.Id = Id;
        this.nomeModello = nomeModello;
        this.tipo = tipo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNomeModello() {
        return nomeModello;
    }

    public void setNomeModello(String nomeModello) {
        this.nomeModello = nomeModello;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
