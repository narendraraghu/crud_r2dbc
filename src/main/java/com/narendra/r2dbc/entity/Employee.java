package com.narendra.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  @Id
  private Long id;

  private String name;

  private String department;

  @Column("company_id")
  private String companyId;

}
