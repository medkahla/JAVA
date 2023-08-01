public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;

        double dripPrice = 2.5;
        double lattePrice = 4.5;
        double cappucinoPrice = 5.5;

    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";

        String customer2 = "Sam ";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // Example:
        System.out.println(generalGreeting + customer1); // Cindhuri
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder1){
            System.out.println("Your order is ready "+ customer1 +" and it cost " + dripPrice);
        }else{
            System.out.println("Sorry not ready yet!");
        }

        System.out.println(generalGreeting + customer4); // Noah
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder4){
            System.out.println("Your order is ready, "+ customer4 +", and it cost " + cappucinoPrice);
        }else{
            System.out.println("Sorry not ready yet!");
        }

        System.out.println(generalGreeting + customer2); // Sam
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder2){
            System.out.println("Your order is ready, "+ customer2 +", and it cost " + lattePrice*2);
        }else{
            System.out.println("Sorry not ready yet!");
        }

        System.out.println(generalGreeting + customer3); // Jimmy
        System.out.println("Here's your order," + customer3 + " and i will give you back" + (lattePrice-dripPrice)); // Sam
    }
}
