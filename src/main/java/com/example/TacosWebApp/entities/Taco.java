package com.example.TacosWebApp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @JoinTable(name = "taco_ingredients",
                joinColumns = @JoinColumn(name = "taco_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    private List<Ingredient> ingredients;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @PrePersist
    void createAt() {
        this.createdAt = new Date();
    }

}
