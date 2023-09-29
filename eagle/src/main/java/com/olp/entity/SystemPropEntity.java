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

    public SystemPropEntity() {
    }

    public SystemPropEntity(long id, String description, boolean enabled, String propKey, String propValue) {
        this.id = id;
        this.description = description;
        this.enabled = enabled;
        this.propKey = propKey;
        this.propValue = propValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

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
