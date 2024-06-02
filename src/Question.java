public class Question {
    private String engWord;
    private String rusWord;

    public Question(String engWord, String rusWord) {
        this.engWord = engWord;
        this.rusWord = rusWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getRusWord() {
        return rusWord;
    }

    public void setRusWord(String rusWord) {
        this.rusWord = rusWord;
    }

    @Override
    public String toString() {
        return "Question{" +
                "engWord='" + engWord + '\'' +
                ", rusWord='" + rusWord + '\'' +
                '}';
    }
}
