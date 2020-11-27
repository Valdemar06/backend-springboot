package com.valdemar.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task", schema = "tasklist")
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Task {
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    private Priority priority;
    private Category category;

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
    @Column(name = "completed")
    public Integer getCompleted() {
        return completed;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    public Priority getPriority() {
        return priority;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }
}
