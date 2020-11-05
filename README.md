# MoneySuperMarket.com 
## Java Developer Technical Test

## Overview

A technical exercise to be used in developer interviews. Can be done either as a pairing exercise or alone by a single
developer.

## Prerequisites (September 2020)

* IntelliJ Community edition: https://www.jetbrains.com/idea/download/
* Microsoft teams - desktop edition: https://www.microsoft.com/en-gb/microsoft-365/microsoft-teams/download-app 

## Exercise

Create an application that calls the below bitcoin exchanges to retrieve rate information:
 * https://blockchain.info/ticker
 * https://api.exmo.com/v1/ticker

Find the exchange with the highest selling price (also known as "bid price") for "USD" and "BTC_USD" currencies and print out:
 * The name of the API
 * The selling price

## Technologies

Repository contains a basic skeleton project with an empty service class and a basic test. The following dependencies
have already been brought in.
 * Java 1.8
 * Gradle
 * JUnit
 * Mockito
 * Hamcrest/AssertJ
