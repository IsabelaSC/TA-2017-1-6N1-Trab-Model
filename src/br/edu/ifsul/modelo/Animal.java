package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_animal",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
//    @Column(name = "genero", nullable = false)
//    private Boolean genero;
//    @NotNull(message = "O tipo não pode ser nulo.")
//    @Length(max = 40, message = "O tipo não pode ter mais de {max} caracteres.")
//    @NotBlank(message = "O nome não pode ser em branco.")
//    private String tipo;
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Column(name = "idade", length = 40, nullable = false)
    private String idade;
    @Column(name = "cor", length = 40, nullable = false)
    private String cor;
    @Column(name = "pelagem", length = 40, nullable = false)
    private String pelagem;
    @NotNull(message = "Campo castrado não pode ser nulo.")
    @Column(name = "castrado", nullable = false)
    private Boolean castrado;
    @NotNull(message = "A raça não pode ser nula.")
    @ManyToOne
    @JoinColumn(name = "raca", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_animal_raca"))
    private Raca raca;

//    @ManyToOne
//    @JoinColumn(name = "adocao", referencedColumnName = "id", nullable = false,
//            foreignKey = @ForeignKey(name = "fk_animal_adocao"))
//    Adocao adocao;
    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

//    public Adocao getAdocao() {
//        return adocao;
//    }
//
//    public void setAdocao(Adocao adocao) {
//        this.adocao = adocao;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

}
