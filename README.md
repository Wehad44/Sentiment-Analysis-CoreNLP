# Sentiment Analysis (Stanford CoreNLP)

A Java console application that reads a sentence and classifies it as **Positive**, **Negative**, **Fact**, or **Neutral**.

The project combines Stanford CoreNLP's sentiment annotator with simple keyword-based and rule-based checks to improve the classification results.

## Requirements

- JDK 17+
- Maven

> ⚠️ **Note:** The CoreNLP English models dependency is large and may require several hundred MB of downloads. The first `mvn compile` command may take some time.

## Run It

```bash
mvn compile exec:java
```

Then type a sentence when prompted and press Enter.

## Project Layout

```text
src/main/java/com/example/sentimentanalysis/
├── SentimentAnalysis.java   # Entry point; reads input and prints the classification
└── NLP.java                 # CoreNLP pipeline and classification rules
```

## Classification Categories

- **Positive** – Sentences expressing positive sentiment
- **Negative** – Sentences expressing negative sentiment
- **Fact** – Factual statements or sentences containing factual indicators
- **Neutral** – Statements that do not clearly express positive, negative, or factual sentiment

## Fixes Made from the Original Version

- Fixed keyword checks such as `"Love"`, `"Like"`, `"Amazing"`, `"Great"`, `"Was"`, and `"Were"` by converting the keywords to lowercase to match the already-lowercased input.
- Fixed the fallback classification logic so that `"Fact"` is returned only when a number or factual verb is detected; otherwise, the result is `"Neutral"`.
- Removed `SimpleSentiment.java`, an empty and unused class from an earlier version.

## Technologies Used

- Java
- Stanford CoreNLP
- Maven
- Natural Language Processing (NLP)

## Author

Developed by **Wehad Abdullah**.
