package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Isabela
 */
@Entity
@Table(name = "resgate")
public class Resgate implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_resgate",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Calendar data;
    private String situacao;
    private String local;
    private String descricao;
    private Boolean reincidente;
    @ManyToOne
    @JoinColumn(name = "animal", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_resgate_animal"))
    private Animal animal;
    @OneToMany(mappedBy = "resgate", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProcedimentoPosResgate> procedimentos = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "responsavelResgate",
            joinColumns
            = @JoinColumn(name = "resgate", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "responsavel", referencedColumnName = "id",
                    nullable = false))
    private List<Responsavel> responsaveisResgates = new ArrayList<>();

    public Resgate() {
    }

    public void adicionarProcedimento(ProcedimentoPosResgate obj) {
        obj.setResgate(this);
        this.procedimentos.add(obj);
    }

    public void removerProcedimento(int idx) {
        this.procedimentos.remove(idx);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getReincidente() {
        return reincidente;
    }

    public void setReincidente(Boolean reincidente) {
        this.reincidente = reincidente;
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
        final Resgate other = (Resgate) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<ProcedimentoPosResgate> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<ProcedimentoPosResgate> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public List<Responsavel> getResponsaveisResgates() {
        return responsaveisResgates;
    }

    public void setResponsaveisResgates(List<Responsavel> responsaveisResgates) {
        this.responsaveisResgates = responsaveisResgates;
    }

}
