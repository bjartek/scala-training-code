package scalaexamples.intro

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class MyFirstTest extends EmptyTest{


  @Test
  def testThatThisFails() {
    assertEquals("foo", "foo")
  }

}
