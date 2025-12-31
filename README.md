# Java Strategy Backtesting Framework

A simple, extensible Java-based backtesting engine for evaluating *rule-based trading strategies* on historical price data.

This project demonstrates the core mechanics of a trading backtest — data loading, signal generation, position management, and PnL calculation — using a *moving average crossover* strategy as an example.

---

## Features

- Clean separation between *strategy logic* and *backtesting engine*
- Pluggable strategy interface for rapid experimentation
- Simple position management (long-only, single position)
- Trade-by-trade logging with entry, exit, and PnL
- CSV-based price input for easy experimentation

---

## Project Structure

```text
.
├── Backtester.java          # Backtest engine and PnL tracking
├── Load.java                # CSV price loader
├── Main.java                # Entry point
├── Strategy.java            # Strategy interface
├── MovingAverageCrossStrategy.java
└── prices.csv               # Sample historical prices
```

---

## Usage

Compile: `javac *.java`
Run: `java Main`
