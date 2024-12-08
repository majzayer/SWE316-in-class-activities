public interface OrderProcessor {
   Receipt checkoutCart(Cart cart, PaymentDetails paymentDetails)
            throws InsufficientFundsException, InvalidPaymentDetailsException, EmptyCartException, SecurityException;
}
