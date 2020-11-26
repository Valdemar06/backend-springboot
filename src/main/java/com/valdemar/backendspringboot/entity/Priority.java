package com.valdemar.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "priority", schema = "tasklist")
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Priority {
    private Long id;
    private String title;
    private String color;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

}
