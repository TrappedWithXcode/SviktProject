package edu.fei.piecing.Model; //Grouping related classes (somethink like folder in a file directory), This is user-defined package...

import jakarta.persistence.*; // In this statements we imported from external librares

@Entity //lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity
// instance corresponds to a row in that table. The primary programming artifact of an entity is the entity class, although entities can use helper classes.
@Table(name="Students")// vypise tabulku s udajmi students??
public class Student { //Main
    public Integer getId() {
        return uid;
    }  //

    public void setId(Integer uid) {
        this.uid = uid;
    } //

    public String getName() {
        return name;
    } //

    public void setName(String name) {
        this.name = name;
    } //

    public String getClss() {
        return clss;
    } //

    public void setClss(String clss) {
        this.clss = clss;
    } //Defining variables

    @Id //Specifies the primary key of an entity. The field or property to which the Id annotation is applied...
    @Column(name="uid")  //Specifies the mapped column for a  property or field, if no Column annotation is specified, the default values apply
    @GeneratedValue
    //The GeneratedValue annotation may be applied to a primary key property or field of an entity or mapped superclass
    // in conjunction with the Id annotation. The use of the GeneratedValue annotation is only required to be supported for simple primary keys.
    private Integer uid;
    private String name;
    @Column(name = "class") //Specifies the mapped column for a  property or field, if no Column annotation is specified, the default values apply
    private String clss;

}
//