package ir.androiddoni.javaClass;

/**
 * Created by Android on 9/30/2016.
 */
public class Personality {

    private int Id;
    private String Name;
    private int Age;
    private String description;

    public Personality() {

    }

    public Personality(int a) {

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
