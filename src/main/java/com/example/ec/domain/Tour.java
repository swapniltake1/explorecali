package com.example.ec.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Tour contains all attributes of an Explore California Tour.
 *
 * Created by Mary Ellen Bowman
 */
@Entity
public class Tour implements Serializable{
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    private Integer id;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String blurb;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;


    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name="tour_package_code")
    private TourPackage tourPackage;

    @Column
    @Enumerated(EnumType.STRING)
=======
    private TourPackage tourPackage;

    @Column
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    private Difficulty difficulty;

    @Column
    private Region region;

    public Tour(String title, String description, String blurb, Integer price, String duration, String bullets,
                String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    protected Tour() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

<<<<<<< HEAD
    public String getDescription() {
        return description;
    }

    public String getBlurb() {
        return blurb;
    }

=======
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public Integer getPrice() {
        return price;
    }

<<<<<<< HEAD
=======
    public void setPrice(Integer price) {
        this.price = price;
    }

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public String getDuration() {
        return duration;
    }

<<<<<<< HEAD
=======
    public void setDuration(String duration) {
        this.duration = duration;
    }

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public String getBullets() {
        return bullets;
    }

<<<<<<< HEAD
=======
    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public String getKeywords() {
        return keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

<<<<<<< HEAD
=======
    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public Difficulty getDifficulty() {
        return difficulty;
    }

<<<<<<< HEAD
    public Region getRegion() {
        return region;
=======
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blurb='" + blurb + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                ", bullets='" + bullets + '\'' +
                ", keywords='" + keywords + '\'' +
                ", tourPackage=" + tourPackage +
                ", difficulty=" + difficulty +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(title, tour.title) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(blurb, tour.blurb) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(duration, tour.duration) &&
                Objects.equals(bullets, tour.bullets) &&
                Objects.equals(keywords, tour.keywords) &&
                Objects.equals(tourPackage, tour.tourPackage) &&
                difficulty == tour.difficulty &&
                region == tour.region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region);
    }
}
