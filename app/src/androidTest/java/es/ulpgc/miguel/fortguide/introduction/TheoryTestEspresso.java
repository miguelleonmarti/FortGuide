package es.ulpgc.miguel.fortguide.introduction;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.miguel.fortguide.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TheoryTestEspresso {

  @Rule
  public ActivityTestRule<IntroductionActivity> mActivityTestRule = new ActivityTestRule<>(IntroductionActivity.class);

  @Test
  public void theoryTestEspresso() {
    ViewInteraction appCompatButton = onView(
        allOf(withId(R.id.buttonContinue), withText("CONTINUAR"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                1),
            isDisplayed()));
    appCompatButton.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction linearLayout = onView(
        allOf(withId(R.id.theoryLayout),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.ScrollView")),
                    0),
                3)));
    linearLayout.perform(scrollTo(), click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction recyclerView = onView(
        allOf(withId(R.id.theoryList),
            childAtPosition(
                withClassName(is("android.support.constraint.ConstraintLayout")),
                3)));
    recyclerView.perform(actionOnItemAtPosition(3, click()));

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    pressBack();

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton2 = onView(
        allOf(withId(R.id.addButton),
            childAtPosition(
                allOf(withId(R.id.layout1),
                    childAtPosition(
                        withClassName(is("android.support.constraint.ConstraintLayout")),
                        2)),
                0),
            isDisplayed()));
    appCompatButton2.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatEditText = onView(
        allOf(withId(R.id.userEditText),
            childAtPosition(
                allOf(withId(R.id.relative1),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText.perform(replaceText("Dayron"), closeSoftKeyboard());

    ViewInteraction appCompatEditText2 = onView(
        allOf(withId(R.id.nameEditText),
            childAtPosition(
                allOf(withId(R.id.relative2),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText2.perform(replaceText("Teoria Espresso"), closeSoftKeyboard());

    ViewInteraction appCompatEditText3 = onView(
        allOf(withId(R.id.descriptionEditText),
            childAtPosition(
                allOf(withId(R.id.relative3),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText3.perform(replaceText("Esto es una prueba con Espresso"), closeSoftKeyboard());

    ViewInteraction appCompatButton3 = onView(
        allOf(withId(R.id.sendButton), withText("ENVIAR"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.support.constraint.ConstraintLayout")),
                    5),
                1),
            isDisplayed()));
    appCompatButton3.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction recyclerView2 = onView(
        allOf(withId(R.id.theoryList),
            childAtPosition(
                withClassName(is("android.support.constraint.ConstraintLayout")),
                3)));
    recyclerView2.perform(actionOnItemAtPosition(5, click()));

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    pressBack();

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton4 = onView(
        allOf(withId(R.id.addButton),
            childAtPosition(
                allOf(withId(R.id.layout1),
                    childAtPosition(
                        withClassName(is("android.support.constraint.ConstraintLayout")),
                        2)),
                0),
            isDisplayed()));
    appCompatButton4.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatEditText4 = onView(
        allOf(withId(R.id.userEditText),
            childAtPosition(
                allOf(withId(R.id.relative1),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText4.perform(replaceText("fghfgh"), closeSoftKeyboard());

    ViewInteraction appCompatEditText5 = onView(
        allOf(withId(R.id.nameEditText),
            childAtPosition(
                allOf(withId(R.id.relative2),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText5.perform(replaceText("asdasd"), closeSoftKeyboard());

    ViewInteraction appCompatEditText6 = onView(
        allOf(withId(R.id.descriptionEditText),
            childAtPosition(
                allOf(withId(R.id.relative3),
                    childAtPosition(
                        withClassName(is("android.widget.LinearLayout")),
                        1)),
                0),
            isDisplayed()));
    appCompatEditText6.perform(replaceText("sdfsdfsdf"), closeSoftKeyboard());

    ViewInteraction appCompatButton5 = onView(
        allOf(withId(R.id.cancelButton), withText("Cancelar"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.support.constraint.ConstraintLayout")),
                    5),
                0),
            isDisplayed()));
    appCompatButton5.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton6 = onView(
        allOf(withId(R.id.bananaButton),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.support.constraint.ConstraintLayout")),
                    1),
                0),
            isDisplayed()));
    appCompatButton6.perform(click());
  }

  private static Matcher<View> childAtPosition(
      final Matcher<View> parentMatcher, final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent)
            && view.equals(((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}
