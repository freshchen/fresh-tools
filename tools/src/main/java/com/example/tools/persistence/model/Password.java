package com.example.tools.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@Entity
@Table
@Data
@NoArgsConstructor
public class Password implements Serializable {

    private static final long serialVersionUID = -8268812975716347468L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String password;
}
