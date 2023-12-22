package br.com.ecstech.messenger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class ApplicationUser implements UserDetails {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Getter
    @Setter
    @Column(unique = true)
    private String username;

    @Getter
    @Setter
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    private Set<Role> authorities = new HashSet<>();


    public  ApplicationUser(){

    }
    public  ApplicationUser(String username, String password, Set<Role> authorities){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
