package pages;

import com.mytaxi.android_demo.R;

import Util.MyTaxiConstants;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kapil.kumar1 on 02/10/18.
 */

public class TestLoginFragement {


    public TestLoginFragement(){

        onView(withId(R.id.edt_username)).perform(typeText(MyTaxiConstants.USER_NAME));
        onView(withId(R.id.edt_password)).perform(typeText(MyTaxiConstants.PASS_WORD));
    }


    public void clickonLoginButton(){

        onView(withId(R.id.btn_login)).perform(click());

    }

}
