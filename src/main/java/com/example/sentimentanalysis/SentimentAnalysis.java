package com.example.sentimentanalysis;

import java.util.Scanner;

public class SentimentAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NLP nlp = new NLP();

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String result = nlp.classifySentence(sentence);

        System.out.println("Classification: " + result);

        scanner.close();
    }
}