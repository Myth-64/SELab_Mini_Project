package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/**
 * <ul>
 * <li>This class represents a Role in the system</li>.
 * <li>It contains various attributes such as id and name</li>.
 * <li>The User class is annotated with JPA annotations to map it to a database table</li>.
 * </ul> 
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    /**
     * The unique identifier for the Role.
     *
     * <p>Generated automatically using the GenerationType.IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}