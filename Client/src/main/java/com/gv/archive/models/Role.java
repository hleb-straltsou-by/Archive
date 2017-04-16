package com.gv.archive.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("role")
public enum Role {
    GUEST, USER, ADMIN;
}
