package io.games.simple.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user")
public class UserEntity implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private long id;

    @NotEmpty
    @Length(max=255)
    private String login;

    @NotEmpty
    @Length(max=255)
    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;

    @Builder.Default
    private boolean enabled = true;

    private int winNumber;

    private int loseNumber;

    private int numberOfPlayedGame;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    public String getUsername() { return login; }

    public float getWinLoseRatio(){
        if(numberOfPlayedGame == 0) return 0;
        return (winNumber - loseNumber)/(numberOfPlayedGame);
    }
}
