package edu.ucentral.vinni.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "portatiles")
@Entity
public class Portatil extends PanacheEntity {
    public String serial;
    public String marca;
    public int memoria;
}
