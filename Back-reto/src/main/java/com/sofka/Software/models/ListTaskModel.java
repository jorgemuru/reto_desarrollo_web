package com.sofka.Software.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "listaTarea")
public class ListTaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = false, nullable = false)
    private Boolean completed;
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * relacion muchos a uno , implementa la relacion con la clase primaria lista
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "listTask_id", nullable = false)

    @JsonBackReference
    private ListModel listaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListModel getListaid() {
        return listaid;
    }

    public void setListaid(ListModel listaid) {
        this.listaid = listaid;
    }
    public ListTaskModel(Long id, Boolean completed, String name, ListModel listaid) {
        this.id = id;
        this.completed = completed;
        this.name = name;
        this.listaid = listaid;
    }
    public ListTaskModel() {
    }
}//fin clase
