package com.valdemar.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "tasklist")
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;

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
    @Column(name = "completed_count")
    public Long getCompletedCount() {
        return completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count")
    public Long getUncompletedCount() {
        return uncompletedCount;
    }
}
