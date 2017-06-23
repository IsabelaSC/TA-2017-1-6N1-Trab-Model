package br.edu.ifsul.modelo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Isabela
 */
@Entity
@Table(name = "procedimentoPosResgate")
public class ProcedimentoPosResgate {

    @Id
    @SequenceGenerator(name = "seq_procedimentoPosResgate", sequenceName = "seq_procedimentoPosResgate_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_procedimentoPosResgate", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String tipo;
    private String descricao;
    @NotNull(message = "O resgate não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "resgate", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_procedimentoPosResgate_resgate"))
    private Resgate resgate;

    public ProcedimentoPosResgate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoPosResgate other = (ProcedimentoPosResgate) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Resgate getResgate() {
        return resgate;
    }

    public void setResgate(Resgate resgate) {
        this.resgate = resgate;
    }

}
