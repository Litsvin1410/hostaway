package org.example.pages;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePage {

    protected static final Duration SHORTEST = Duration.of(5, ChronoUnit.SECONDS);
    protected static final Duration SHORT = Duration.of(10, ChronoUnit.SECONDS);

}