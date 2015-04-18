package com.example.iit.dhakathon;

/**
 * Created by Shohag on 17-Apr-15.
 */
public class URL {
    public static String URL_FOR_ALL_CANDIDATE_LIST="http://www.citycorpelections.org/candidate?type=council&city=ccc&ward=1970";
    public static String URL_FOR_ALL_COUNCILOR_CCC="http://www.citycorpelections.org/candidate?type=council&city=ccc";
    public static String URL_FOR_ALL_COUNCILOR_DNCC="http://www.citycorpelections.org/candidate?type=council&city=dncc";
    public static String URL_FOR_ALL_COUNCILOR_DSCC="http://www.citycorpelections.org/candidate?type=council&city=dscc";

    public static String URL[][]={
            {"http://www.citycorpelections.org/candidate?type=mayor&city=dncc","http://www.citycorpelections.org/candidate?type=council&city=dncc","http://www.citycorpelections.org/candidate?type=council&city=dncc"},
            {"http://www.citycorpelections.org/candidate?type=mayor&city=dscc","http://www.citycorpelections.org/candidate?type=council&city=dscc","http://www.citycorpelections.org/candidate?type=council&city=dscc"},
            {"http://www.citycorpelections.org/candidate?type=mayor&city=ccc","http://www.citycorpelections.org/candidate?type=council&city=ccc","http://www.citycorpelections.org/candidate?type=council&city=ccc"}
    };
}
