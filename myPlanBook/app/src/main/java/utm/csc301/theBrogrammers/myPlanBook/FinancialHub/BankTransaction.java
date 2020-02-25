package utm.csc301.theBrogrammers.myPlanBook.FinancialHub;

public class BankTransaction {

    private String institution;
    private int cardNum, amount;
    private boolean isDebit;

    // Empty constructor
    public BankTransaction(){}

    public BankTransaction(String institution,int cardNum, int amount,
                           boolean isDebit, String date){
        this.institution = institution;
        this.amount = amount;
        this.isDebit = isDebit;
        this.cardNum = cardNum;
    }

    public String getInstitution() {
        return institution;
    }

    public int getCardNum() {
        return cardNum;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }
}
