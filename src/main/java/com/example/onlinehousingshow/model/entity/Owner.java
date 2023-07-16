package com.example.onlinehousingshow.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Table(name = "owners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,name = "owner_user_name",unique = true)
    private String ownerUserName;
    @Column(nullable = false,name = "owner_name")
    private String ownerName;
    @Column(nullable = false,name = "owner_email")
    private String ownerEmail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,name = "created_date")
    private LocalDate createdDate;
    @Column(nullable = false,name = "updated_date")
    private LocalDate updatedDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return ownerUserName;
    }

    @Override
    public String getPassword() {
        return password;
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
