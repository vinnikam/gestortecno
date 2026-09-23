package edu.ucentral.vinni.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "portatiles")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Portatil extends PanacheEntity {
    public String serial;
    public String marca;
    public int memoria;
}
