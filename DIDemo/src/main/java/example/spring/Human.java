package example.spring;

public class Human {
    private Heart heart;

    public void setHeart(Heart heart) {
        this.heart = heart;
    }

    public void pumping() {
        if (heart != null) {
            System.out.println("Name: " + heart.getNameOfAnimal() + 
                               ", No of hearts: " + heart.getNoOfHearts() + 
                               ", ID: " + heart.getId() + 
                               ", Value: " + heart.getValue());
        } else {
            System.out.println("Heart is not available");
        }
    }
}

