package com.example.storyEndPoint.enums;

import java.util.Set;

public enum Role {

    ADMIN(Set.of(Permissions.ADD_NOTE, Permissions.DELETE_NOTE)),
    USER(Set.of(Permissions.READ_NOTE));

    final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
