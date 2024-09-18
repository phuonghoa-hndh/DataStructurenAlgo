package Hw1;

public class WordCounter {
    private ListInterface<WordCount> wordCounts;

    public WordCounter() {
        wordCounts = new SimpleArrayList<>();
    }

    public void countWords(String text) {
        String[] words = text.split("\\s+"); // Split text into words
        for (String word : words) {
            WordCount wordCount = new WordCount(word);
            int index = indexOfWord(wordCount);
            if (index != -1) {
                wordCounts.get(index).incrementCount();
            } else {
                wordCounts.add(wordCount);
            }
        }
    }

    private int indexOfWord(WordCount wordCount) {
        for (int i = 0; i < wordCounts.size(); i++) {
            if (wordCounts.get(i).equals(wordCount)) {
                return i;
            }
        }
        return -1;
    }

    public void displayWordCounts() {
        for (WordCount wordCount : wordCounts) {
            System.out.println(wordCount.getWord() + ": " + wordCount.getCount());
        }
    }

    public static void main(String[] args) {
        String text = "Sinh viên thực hiện và nộp bài theo quy tắc Sinh viên hoàn thành bài tập trong package có tên Hw2_<MaSinhvien>_<Hovaten>+ - Sinh viên nộp bài làm trên tài khoản của mình bao gồm: + File nén .zip của thư mục chứa package (Hw2_<MaSinhvien>_<Hovaten>.zip)";
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords(text);
        wordCounter.displayWordCounts();
    }
}
