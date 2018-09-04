import java.util.Random;

/**
 * @author Michał Mitros
 */
public class Hiragana {

    private String[] hiragana;
    private String[] hepburn;
    private int numberOfSigns;

    public Hiragana() {
        String[] tmp_hepburn = {
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko",
                "sa", "shi", "su", "se", "so",
                "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "wa", "wo",
                "ga", "gi", "gu", "ge", "go",
                "za", "ji", "zu", "ze", "zo",
                "da", "de", "do",
                "ba", "bi", "bu", "be", "bo",
                "pa", "pi", "pu", "pe", "po",
                "n"
        };
        hepburn = tmp_hepburn;

        String[] tmp_hiragana = {
                "あ", "い", "う", "え", "お",
                "か", "き", "く", "け", "こ",
                "さ", "し", "す","せ", "そ",
                "た", "ち", "つ", "て", "と",
                "な", "に", "ぬ", "ね", "の",
                "は", "ひ", "ふ", "へ", "ほ",
                "ま", "み", "む", "め", "も",
                "や", "ゆ", "よ",
                "ら", "り", "る", "れ", "ろ",
                "わ", "を",
                "が", "ぎ", "ぐ", "げ", "ご",
                "ざ", "じ", "ず","ぜ", "ぞ",
                "だ", "で", "ど",
                "ば", "び", "ぶ", "べ", "ぼ",
                "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",
                "ん"
        };
        hiragana = tmp_hiragana;

        numberOfSigns = hepburn.length;
    }

    public int getRandomIndex() {
        return (int)(Math.random()*numberOfSigns);
    }

    public String getHepburnFromIndex(int index) {
        if(index < hepburn.length && index >= 0) {
            return hepburn[index];
        }
        return "_error_";
    }

    public String getSignFromIndex(int index) {
        if(index < hiragana.length && index >= 0) {
            return hiragana[index];
        }
        return "_error_";
    }

    public boolean isCorrect(String s, int index) {
        if(index < 0 || index >= numberOfSigns)
            return false;
        s = s.toLowerCase();
        return hepburn[index].equals(s);
    }
}