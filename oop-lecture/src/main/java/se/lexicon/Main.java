package se.lexicon;

public class Main {
    public static void main(String[] args) {

        //Instance of car = Object

/*        Car volvoObj = new Car();
        volvoObj.brand = "Volvo";
        volvoObj.model = "V60";

//        System.out.println(volvoObj.brand + " " + volvoObj.model);
        System.out.println(volvoObj.carInfo());



        Car VWObj = new Car();

        VWObj.brand = "VW";
        VWObj.model = "ID 4";
        VWObj.color = "White";
        VWObj.year = 2023;
//        VWObj.mileage = 0;

        System.out.println(VWObj.carInfo());


        VWObj.drive(500);
        VWObj.drive(100);

        System.out.println("Mileage= " + VWObj.getMileage());*/

/*        Car VWObj = new Car();

        VWObj.setBrand("VW");
        VWObj.setModel("ID 4");
        VWObj.setColor(null);
        VWObj.setYear(2023);

        System.out.println(VWObj.getColor()); // GRAY
        System.out.println("VWObj.getMileage() = " + VWObj.getMileage()); // 0.0
*/
        //_______________________

       //Calling a constructor
        Person erik = new Person("Erik", "Svensson", "19900105-1234", 46);

//        erik.setFirstName("Erik");
//        erik.setLastName("Svensson");
//        erik.setAge(9000);

        System.out.println("erik.getPersonInfo() = " + erik.getPersonInfo());


//        Person simon = new Person(); //Default constructor not available anymore



    }
}