package Stream.Tasks.Eshop.expertsoft1.model;

public class PaymentInfo {

    public enum CardType {
        VISA,
        MASTERCARD
    }

    private CardType cardType;
    private String cardNumber;
    private String securityCode;

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
