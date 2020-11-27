package com.valdemar.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "stat", schema = "tasklist")
@Setter
@EqualsAndHashCode(callSuper = false)
public class Stat {
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "completed_total")
    public Long getCompletedTotal() {
        return completedTotal;
    }

    @Basic
    @Column(name = "uncompleted_total")
    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }
}
