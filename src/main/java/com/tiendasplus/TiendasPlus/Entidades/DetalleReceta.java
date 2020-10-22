/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hmsotoj
 */
@Entity
@Table(name = "detalle_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReceta.findAll", query = "SELECT d FROM DetalleReceta d")
    , @NamedQuery(name = "DetalleReceta.findByIdregistro", query = "SELECT d FROM DetalleReceta d WHERE d.idregistro = :idregistro")
    , @NamedQuery(name = "DetalleReceta.findByIdreceta", query = "SELECT d FROM DetalleReceta d WHERE d.idreceta = :idreceta")
    , @NamedQuery(name = "DetalleReceta.findByIdproducto", query = "SELECT d FROM DetalleReceta d WHERE d.idproducto = :idproducto")
    , @NamedQuery(name = "DetalleReceta.findByCantidad", query = "SELECT d FROM DetalleReceta d WHERE d.cantidad = :cantidad")})
public class DetalleReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Integer idregistro;
    @Column(name = "idreceta")
    private Integer idreceta;
    @Column(name = "idproducto")
    private Integer idproducto;
    @Column(name = "cantidad")
    private Integer cantidad;

    public DetalleReceta() {
    }

    public DetalleReceta(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Integer getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(Integer idreceta) {
        this.idreceta = idreceta;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleReceta)) {
            return false;
        }
        DetalleReceta other = (DetalleReceta) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetalleReceta[ idregistro=" + idregistro + " ]";
    }
    
}
