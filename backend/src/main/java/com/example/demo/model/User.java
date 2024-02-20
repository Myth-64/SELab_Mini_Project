package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
/**
 * <ul>
 * <li>This class represents a User in the system</li>.
 * <li>It contains various attributes such as id, name, username, email, password, and roles</li>.
 * <li>The User class is annotated with JPA annotations to map it to a database table</li>.
 * <li>It also utilizes Lombok annotations for generating getters, setters, constructors, and other</li>
 * </ul> .
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The name of the user.
     */
    private String name;
    
    /**
     * The unique username of the user.
     */
    @Column(nullable = false, unique = true)
    private String username;
     /**
     * The unique email address of the user.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * The password associated with the user.
     */
    @Column(nullable = false)
    private String password;
     /**
     * The roles assigned to the user. A user can have multiple roles.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )    
    private Set<Role> roles;
/**
     * The tracks associated with the user. A user can be associated with multiple tracks.
     */
    @ManyToMany
    @JoinTable(
        name="userTracks",
        joinColumns = @JoinColumn(name="Id"),
        inverseJoinColumns = @JoinColumn(name="trackId")
    )
    Set<Track> tracks;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }
}