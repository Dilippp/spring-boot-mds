package com.mds.springbootmds.kela;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime orderAt;
}
