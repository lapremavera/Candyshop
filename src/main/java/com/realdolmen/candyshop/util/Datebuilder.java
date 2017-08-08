package com.realdolmen.candyshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UnknownFormatConversionException;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class Datebuilder {

    public static Date createDate (String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new UnknownFormatConversionException("Wrong date");
        }
    }

    public static String createString (Date date) {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);

        }
    }


