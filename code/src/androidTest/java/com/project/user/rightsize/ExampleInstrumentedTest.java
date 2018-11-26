package com.project.user.rightsize;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void manOneDifferent() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(true,  appContext,92, 85, 84, 38);
        a.calculate();
        collector.checkThat(
                "Male size test. One parameter from another interval. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(50)
        );
    }
    @Test
    public void manAllDifferent() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(true,  appContext,104, 81, 84, 38);
        a.calculate();
        collector.checkThat(
                "Male size test. All parameters from differents intervals. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(52)
        );
    }

    @Test
    public void manAllEqual() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(true,  appContext,92, 80, 88, 38);
        a.calculate();
        collector.checkThat(
                "Male size test. All parameters from one interval. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(48)
        );
    }

    @Test
    public void womanOneDifferent() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,88, 56, 88);
        a.calculate();
        collector.checkThat(
                "Female size test. One parameter from another interval. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(44)
        );
    }
    @Test
    public void womanAllDifferent() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,103, 81, 88);
        a.calculate();
        collector.checkThat(
                "Female size test. All parameters from differents intervals. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(54)
        );
    }

    @Test
    public void womanAllEqual() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,88, 62, 88);
        a.calculate();
        collector.checkThat(
                "Female size test. All parameters from one interval. " +
                        "The calculation is not made on the maximum value",
                a.result.rusSize,
                is(44)
        );
    }

    @Test
    public void typeIsApple() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,88, 86, 88);
        a.typeOfBody();
        collector.checkThat(
                "Type of body test. Wrong result",
                a.result.typeOfBody,
                is("Яблоко")
        );
    }

    @Test
    public void typeIsHourglass() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,88, 66, 88);
        a.typeOfBody();
        collector.checkThat(
                "Type of body test. Wrong result",
                a.result.typeOfBody,
                is("Песочные часы")
        );
    }

    @Test
    public void typeIsPear() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        Calculator a = new Calculator(false,  appContext,88, 56, 92);
        a.typeOfBody();
        collector.checkThat(
                "Type of body test. Wrong result",
                a.result.typeOfBody,
                is("Груша ")
        );
    }
}

