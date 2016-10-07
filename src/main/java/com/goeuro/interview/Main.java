package com.goeuro.interview;

import org.apache.commons.cli.*;

import java.util.stream.Collectors;

public class Main {

    /**
     * By convention the program args should be like
     * -c Berlin
     * OR
     * --city Berlin
     * However, since the question suggests to only have the argument as "Berlin", I will go ahead with it.
     * @param args CITY_NAME
     */
    public static void main(String[] args) {
        Options options = new Options();
//        options.addOption("", "city", true, "CityName");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine line = parser.parse( options, args );
            if (line.getArgList().size() > 0) {
                String city = line.getArgList().stream().collect(Collectors.joining(" "));
                new GoEuroApp(city).run();
            } else {
                printHelp();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            printHelp();
        }
        System.exit(0);
    }

    private static void printHelp() {
        HelpFormatter help = new HelpFormatter();
        help.printHelp("java -jar goEuro.jar <CITY_NAME>", new Options());
    }
}
