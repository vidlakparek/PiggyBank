package cz.zcu.marekvidlak.piggybank.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static cz.zcu.marekvidlak.piggybank.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissionsLocal = getPermissions().stream()
                                                                       .map(permission -> new SimpleGrantedAuthority(
                                                                               permission.getPermission()))
                                                                       .collect(Collectors.toSet());
        permissionsLocal.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissionsLocal;
    }
}
