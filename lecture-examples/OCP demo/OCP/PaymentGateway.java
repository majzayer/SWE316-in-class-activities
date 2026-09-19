public class PaymentGateway {

    public void charge(PaymentDetails paymentDetails, double amount) {
        System.out.println("Charged " + amount + " to " + paymentDetails.getAccountId());
    }
}