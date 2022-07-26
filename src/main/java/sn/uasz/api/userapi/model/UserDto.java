package sn.uasz.api.userapi.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    @Column(name = "userId")
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;
    @Column(name = "nom", nullable=false)
    public String nom;
    @Column(name = "prenom", nullable=false)
    public String prenom;

    @Column(name = "email", unique=true, nullable=false)
    public String email;
    @Column(name = "matricule",unique=true, nullable=false)
    public String matricule;
    @Column(name = "telephone",unique=true, nullable=false)
    public String telephone;
    @Column(name = "password",unique=true, nullable=false)
    public String password;
    @Column(name = "ufr", nullable=false)
    public String ufr;
    @Column(name = "departement", nullable=false)
    public String departement;
    @Column(name = "roles", nullable=false)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public Set<RoleDto> roles = new HashSet<>();
    public void addRole(RoleDto roleDto) {
        this.roles.add(roleDto);
    }


}
