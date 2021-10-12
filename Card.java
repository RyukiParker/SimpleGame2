public class Card {

    private Suite suite;
    private int value;

    public Card(int value, Suite suite){
        this.suite = suite;
        this.value = value +2;
    }

    public int getValue() {
        return value;
    }

    public Suite getSuite() {
        return suite;
    }

    @Override
    public String toString() {
        return "["+this.getLetter()+this.getSuiteIcon()+"]";
    }

    private String getLetter(){
        String letter = String.valueOf(this.value);
            switch (this.value){
                case 11:
                    letter = "J";
                    break;
                case 12:
                    letter = "Q";
                    break;
                case 13:
                    letter ="K";
                    break;
                default:
                    letter = String.valueOf(this.value);
                    break;
                case 14:
                    letter = "A";
                    break;
            }
        return letter;
    }

    private String getSuiteIcon(){
        String txt = null;
        switch (this.suite){
            case CLUB:
                txt = "♣";
                break;
            case SPADE:
                txt = "♠";
                break;
            case HEART:
                txt = "♥";
                break;
            case DIAMOND:
                txt = "♢";
                break;
        }
        return txt;
    }
}
