package com.example.TacosWebApp.data;

import com.example.TacosWebApp.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
public class RoleDaoDaoImpl implements RoleDao {

    private EntityManager entityManager;

    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
        theQuery.setParameter("roleName", roleName);

        Role theRole;

        try {
            theRole = theQuery.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }

        return theRole;
    }
}
