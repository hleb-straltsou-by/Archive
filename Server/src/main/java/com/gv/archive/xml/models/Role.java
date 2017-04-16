package com.gv.archive.xml.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("role")
public enum Role {
    GUEST, USER, ADMIN;
}
