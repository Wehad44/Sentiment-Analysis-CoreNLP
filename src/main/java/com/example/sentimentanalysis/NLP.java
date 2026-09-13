package com.example.sentimentanalysis;


import java.util.Properties;
import edu.stanford.nlp.pipeline.*;

public class NLP {

    // Create and initialize the NLP pipeline directly
    private StanfordCoreNLP pipeline = createPipeline();

    
   //  method to create the NLP pipeline
     
    private static StanfordCoreNLP createPipeline() {

        // Create properties object
        Properties props = new Properties();

        // Define NLP processing steps
        // tokenize: split text into words
        // ssplit: split text into sentences
        // pos: part of speech like noun verb
        // parse: syntactic parsing
        // sentiment: detect sentiment of the sentence
        props.setProperty("annotators", "tokenize,ssplit,pos,parse,sentiment");

        // Return initialized pipeline
        return new StanfordCoreNLP(props);
    }
      //Method that analyzes a sentence and returns its classification
    
    public String classifySentence(String sentence) {

        // Convert the sentence into a CoreDocument
        CoreDocument document = new CoreDocument(sentence);

        // Run NLP analysis
        pipeline.annotate(document);

        // Variable to store sentiment result
        String sentiment = "";

        // Extract sentiment from the analyzed sentence
        for (CoreSentence sent : document.sentences()) {
            sentiment = sent.sentiment();
        }

        // Convert sentence to lowercase
        String lower = sentence.toLowerCase();

        // Rule based check for strong positive words
        // (compare against lowercase words since `lower` is already lowercased)
        if (lower.contains("love") || lower.contains("like") ||
            lower.contains("amazing") || lower.contains("great")) {
            return "Positive";
        }

        // Check if sentence contains numbers
        boolean hasNumber = sentence.matches(".*\\d.*");

        // Check for factual verbs
        boolean looksFact =
                lower.contains("is") ||
                lower.contains("are") ||
                lower.contains("was") ||
                lower.contains("were") ||
                lower.contains("has") ||
                lower.contains("have");

        // Sentiment classification
        if (sentiment.equalsIgnoreCase("Positive")) {

            return "Positive";

        } else if (sentiment.equalsIgnoreCase("Negative")) {

            return "Negative";

        } else if (hasNumber || looksFact) {

            return "Fact";

        } else {

            return "Neutral";
        }
    }
}