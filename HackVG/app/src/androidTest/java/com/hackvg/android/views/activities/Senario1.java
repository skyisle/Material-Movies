package com.hackvg.android.views.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

/**
 * Created by skyisle on 3/16/15.
 */

@RunWith(AndroidJUnit4.class)
public class Senario1
        extends ActivityInstrumentationTestCase2<MoviesActivity> {
    private UiDevice mDevice;

    public Senario1() {
        super(MoviesActivity.class
        );
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        mDevice = UiDevice.getInstance(getInstrumentation());

    }

    @Test
    public void testSearchPoiAndCheckPlacesOnTheMap() throws UiObjectNotFoundException {
        // Initialize UiDevice instance

        mDevice.pressHome();

        UiObject allAppsButton = mDevice
                .findObject(new UiSelector().description("앱"));

        allAppsButton.clickAndWaitForNewWindow();

        UiObject daumMap = mDevice
                .findObject(new UiSelector().description("다음지도"));

        daumMap.clickAndWaitForNewWindow();

        UiObject menu = mDevice
                .findObject(new UiSelector().resourceId("net.daum.android.map:id/main_menu_button"));
        menu.click();

        UiObject search = mDevice
                .findObject(new UiSelector().resourceId("net.daum.android.map:id/main_menu_search_button"));

        search.click();

        UiObject searchBox = mDevice
                .findObject(new UiSelector().resourceId("net.daum.android.map:id/edit_text"));

        searchBox.setText("콘래드서울");

        UiObject searchResult1 = mDevice
                .findObject(new UiSelector().resourceId("android:id/text1"));

        if (Objects.equals("콘래드서울", searchResult1.getText())) {
            searchResult1.click();
        } else {
            fail();
        }

        mDevice.pressBack();
        mDevice.pressBack();
    }
}

