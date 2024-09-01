package assessment.star;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StringQuestion unit test class
 * @author Kanagarajan
 */
public class StringQuestionTest {


    @Test
    public void starString_Exception_When_Negative_Numbers() {
        Assert.assertThrows("Should not be negative value. Please try with zero or positive number",
                IllegalArgumentException.class, ()->StringQuestion.starString(-1));
    }

    @Test
    public void starString_When_ZeroOrPositive_Numbers(){
        Assert.assertEquals( StringQuestion.starString(0),"*");
        Assert.assertEquals( StringQuestion.starString(1),"**");
        Assert.assertEquals( StringQuestion.starString(2),"****");
        Assert.assertEquals( StringQuestion.starString(3),"********");
        Assert.assertEquals( StringQuestion.starString(4),"****************");
    }
}