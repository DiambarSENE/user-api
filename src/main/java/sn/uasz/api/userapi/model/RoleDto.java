package sn.uasz.api.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    public Long roleId;
    @Column(name = "name",unique = true, nullable = false)
    public String roleName;
    @Column(name = "roledescription")

    public String roleDescription;
}
