package example.spring;

public class Heart {
    private String nameOfAnimal;
    private int noOfHearts;
    private String id;
    private String value;

    public Heart() {}

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    public int getNoOfHearts() {
        return noOfHearts;
    }

    public void setNoOfHearts(int noOfHearts) {
        this.noOfHearts = noOfHearts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
