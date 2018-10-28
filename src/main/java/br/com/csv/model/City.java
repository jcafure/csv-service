package br.com.csv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City extends BaseEntity{

    @Column(name = "ibge_id")
    private Integer idIbge;

    @Column(name = "uf")
    private String estado;

    @Column(name = "name")
    private String nameCity;

    private boolean capital;

    @Column(name = "lon")
    private BigDecimal longitude;

    @Column(name = "lat")
    private BigDecimal latitude;

    @Column(name = "no_accents")
    private String noAccents;

    @Column(name = "alternative_names")
    private String alternativeNames;

    @Column(name = "microregion")
    private String microRegion;

    @Column(name = "mesoregion")
    private String mesoregion;

    @Column(name = "excluded")
    private boolean excluded;
}
