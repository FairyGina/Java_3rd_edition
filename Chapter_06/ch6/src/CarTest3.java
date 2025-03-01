class Car{
    String color;
    String gearType;
    int door;

    Car(){
        this("white", "auto", 4);
    }

    Car(Car c){
        color = c.color;
        gearType = c.gearType;
        door = c.door;
    }

    Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}


class CarTest3 {
    public static void main(String[] args){
        Car c1 = new Car();
        Car c2 = new Car(c1);
        System.out.println("c1's color: " + c1.color + ", c1's gearType: " + c1.gearType + ", c1's door: " + c1.door);
        System.out.println("c2's color: " + c2.color + ", c2's gearType: " + c2.gearType + ", c2's door: " + c2.door);

        c1.door = 100;

        System.out.println("c1.door = 100; 수행 후");
        System.out.println("c1's color: " + c1.color + ", c1's gearType: " + c1.gearType + ", c1's door: " + c1.door);
        System.out.println("c2's color: " + c2.color + ", c2's gearType: " + c2.gearType + ", c2's door: " + c2.door);
    }
    
}
