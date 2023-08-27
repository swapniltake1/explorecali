package com.example.ec.domain;

/**
 * Enumeration of the region of California.
 *
 * Created by Mary Ellen Bowman
 */
public enum Region {
<<<<<<< HEAD
    Central_Coast("Central Coast"), Southern_California("Southern California"),
    Northern_California("Northern California"), Varies("Varies");
=======
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    private String label;
    private Region(String label) {
        this.label = label;
    }
<<<<<<< HEAD

=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    public static Region findByLabel(String byLabel) {
        for(Region r:Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }
<<<<<<< HEAD

    public String getLabel() {
        return label;
    }
=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
}
