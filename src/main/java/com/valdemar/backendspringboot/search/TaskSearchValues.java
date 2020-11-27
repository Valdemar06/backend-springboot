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

    //Search fields
    private String title;
    private Integer completed;
    private Long priorityId;
    private Long categoryId;

    //paging
    private Integer pageNumber;
    private Integer pageSize;

    //Sorting
    private String sortColumn;
    private String sortDirection;
}
