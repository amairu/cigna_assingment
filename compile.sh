#!/bin/bash

javac @sources.txt

jar cvfm Calculator.jar manifest.txt -c romanCalculator