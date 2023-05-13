package co.develhope.crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_car;

    private String nomeModello;
    private String tipo;

    public Car() {
    }

    public Car(long id_car, String nomeModello, String tipo) {
        this.id_car = id_car;
        this.nomeModello = nomeModello;
        this.tipo = tipo;
    }

    public long getId_car() {
        return id_car;
    }

    public void setId_car(long id_car) {
        this.id_car = id_car;
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
