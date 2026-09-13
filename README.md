# Sentiment Analysis (Stanford CoreNLP)

Reads a sentence from the console and classifies it as **Positive**,
**Negative**, **Fact**, or **Neutral**, combining Stanford CoreNLP's
sentiment annotator with a few simple keyword/rule-based checks.

## Requirements
- JDK 17+
- Maven

⚠️ **Heads up:** the CoreNLP English models dependency is large
(several hundred MB). The first `mvn compile` will take a while to
download it.

## Run it

```bash
mvn compile exec:java
```

Then type a sentence when prompted and press Enter.

## Project layout

```
src/main/java/com/example/sentimentanalysis/
  SentimentAnalysis.java   – entry point, reads input and prints the classification
  NLP.java                 – wraps the CoreNLP pipeline + classification rules
```

## Fixes made from the original version

- The keyword checks (`"Love"`, `"Like"`, `"Amazing"`, `"Great"`, `"Was"`,
  `"Were"`) were being compared against an already-lowercased string, so
  they could never match. Lowercased the keywords so the checks
  actually work.
- The final fallback branch returned `"Fact"` regardless of whether
  `hasNumber`/`looksFact` was true, making that condition pointless.
  Split it into `"Fact"` (when a number or factual verb is present) vs.
  `"Neutral"` (otherwise), so both branches are meaningfully different.
- Removed `SimpleSentiment.java`, an empty, unused class left over from
  an earlier version.
