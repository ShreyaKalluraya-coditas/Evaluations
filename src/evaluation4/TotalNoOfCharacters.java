package evaluation4;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TotalNoOfCharacters {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your string");
        String name = s.nextLine();
        System.out.println("No of times you want to perform");
        int n = s.nextInt();
        for(int k=0;k<n;k++) {
            System.out.println("Enter your option 1:- Count of tokens  2:- Vowels Count and their string 3:- +next new letter of consonants ");
            int option = s.nextInt();
            switch (option) {
                case 1:
                    StringTokenizer str = new StringTokenizer(name, " ");

                    System.out.println(str.countTokens());

                    break;
                case 2:
                    int vowels = 0;
                    String string = "";
                    String names = name.toLowerCase();
                    for (int i = 0; i < name.length(); i++) {
                        if (names.charAt(i) == 'a' || names.charAt(i) == 'e' || names.charAt(i) == 'i' ||
                                names.charAt(i) == 'o' || names.charAt(i) == 'u') {
                            vowels++;
                            string = string + names.charAt(i);
                        }

                    }
                    System.out.println(vowels);
                    System.out.println("String of vowels is  " + string);
                    break;

                case 3:
                    String newString = "";
                    String newName = name.toLowerCase();
                    for (int i = 0; i < name.length(); i++) {
                        char ch = newName.charAt(i);
                        if (ch == 'a' || ch == 'e' || ch == 'i' ||
                                ch == 'o' || ch == 'u') {
                            newString = newString + ch;
                        } else if (ch >= 'a' || ch <= 'z') {
                            ch++;
                            newString = newString + ch;
                        }


                    }
                    System.out.println(newString);
                    break;
            }
        }

    }
    }

//output


//    Enter your string
//        Hii i am shreya
//        Enter your option 1:- Count of tokens  2:- Vowels Count and their string 3:- +next new letter of consonants
//        3
//        iii!i!an!tiseza

//    Enter your string
//        Hii i am shreya
//        Enter your option 1:- Count of tokens  2:- Vowels Count and their string 3:- +next new letter of consonants
//        1
//        4

//    Enter your string
//        Hii i am shreya
//        Enter your option 1:- Count of tokens  2:- Vowels Count and their string 3:- +next new letter of consonants
//        2
//        6
//        String of vowels is  iiiaea



