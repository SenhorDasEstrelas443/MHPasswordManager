package br.com.marcoshssilva.mhpasswordmanager.userservice.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table( name = "account_roles")
@Entity(name = "UserRoles")
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    UserRolesPK id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "grant_date")
    Date grantDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoles userRoles = (UserRoles) o;
        return id.equals(userRoles.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
