package sn.uasz.api.userapi.model;


import java.io.Serializable;

import javax.persistence.*;


import lombok.Data;
import org.mapstruct.Named;


@Entity
@Data
//@Builder
@Table(name = "\"USERS\"")
public class UserDto implements Serializable {
    @EmbeddedId
    private UserId userId;
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "password")
    private String password;
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "ufr")
    private String ufr;
    @Column(name = "departement")
    private String departement;
    @Column(name = "roles")
    private String roles;
}
