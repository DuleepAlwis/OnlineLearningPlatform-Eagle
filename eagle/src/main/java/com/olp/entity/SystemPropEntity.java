package com.olp.entity;

import javax.persistence.*;

@Table(name="system_property_tb")
@Entity
public class SystemPropEntity {

    //# id, description, enabled, prop_key, prop_value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="description")
    private String description;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="prop_key")
    private String propKey;

    @Column(name="prop_value")
    private String propValue;


    @Override
    public String toString() {
        return "SystemPropEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", propKey='" + propKey + '\'' +
                ", propValue='" + propValue + '\'' +
                '}';
    }
}
