
public interface OrderProcessor {
    /**
     * Processes the checkout of the shopping cart and charges the provided payment method.
     *
     * @param cart the shopping cart to be checked out. Must belong to the current user.
     * @param paymentDetails the payment details used to charge the purchase.
     * @return a Receipt containing transaction details if the checkout is successful.
     * @throws InsufficientFundsException if the payment method does not have sufficient funds.
     * @throws InvalidPaymentDetailsException if the payment details are invalid.
     * @throws EmptyCartException if the cart is empty.
     * @throws SecurityException if the cart does not belong to the current user.
     */
   Receipt checkoutCart(Cart cart, PaymentDetails paymentDetails)
            throws InsufficientFundsException, InvalidPaymentDetailsException, EmptyCartException, SecurityException;
}
