package com.example.ec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
import java.io.Serializable;
import java.util.Objects;

/**
 * A Classification of Tours.
 *
 * Created by Mary Ellen Bowman
 */
<<<<<<< HEAD
@Table(name="tour_package")
=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
@Entity
public class TourPackage implements Serializable {
    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage() {
    }

    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
