package com.valdemar.backendspringboot.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class TaskSearchValues {

    String text;
    Integer completed;
    Long priorityId;
    Long categoryId;
}
