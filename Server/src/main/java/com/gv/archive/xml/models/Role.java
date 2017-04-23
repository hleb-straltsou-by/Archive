package com.gv.archive.xml.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("role")
/**
 * specifies available roles for dossiers and users
 * @see com.gv.archive.xml.models.Dossier
 * @see com.gv.archive.xml.models.User
 */
public enum Role {
    GUEST, USER, ADMIN
}
