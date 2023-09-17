package com.cydeo.bootstrap;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
public class DataGenerator {

    public static List<String> STATES;

    public static void initializeData(){
        STATES = Arrays.asList(
                "Alaska",
                "Alabama",
                "Arkansas",
                "Arizona",
                "California",
                "Colorado",
                "Connecticut",
                "Delaware",
                "Florida",
                "Georgia",
                "Hawaii",
                "Iowa",
                "Idaho",
                "Illinois",
                "Indiana",
                "Kansas",
                "Kentucky",
                "Louisiana",
                "Massachusetts",
                "Maryland",
                "Maine",
                "Michigan",
                "Minnesota",
                "Missouri",
                "Mississippi",
                "Montana",
                "NorthCarolina",
                "NorthDakota",
                "Nebraska",
                "NewHampshire",
                "NewJersey",
                "NewMexico",
                "Nevada",
                "NewYork",
                "Ohio",
                "Oklahoma",
                "Oregon",
                "Pennsylvania",
                "RhodeIsland",
                "SouthCarolina",
                "SouthDakota",
                "Tennessee",
                "Texas",
                "Utah",
                "Virginia",
                "Vermont",
                "Washington",
                "Wisconsin",
                "WestVirginia",
                "Wyoming"
        );
    }
}
