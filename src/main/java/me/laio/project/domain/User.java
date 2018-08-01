package me.laio.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

import static java.util.Objects.nonNull;

@Entity
@Getter
@Setter
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha", length = 60)
    private String senha;

    @Column(name = "ativo")
    private boolean ativo;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                "}";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
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
        if (nonNull(this.ativo)) {
            return this.ativo;
        }
        return false;
    }
}
