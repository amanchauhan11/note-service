package com.notes.noteservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NOTE")
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @ManyToOne
  @JoinColumn(name="USER_ID", nullable = false)
  private User user;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "BODY")
  private String body;

  @Column(name = "CREATED_ON")
  @CreationTimestamp
  private Timestamp createdOn;

}
