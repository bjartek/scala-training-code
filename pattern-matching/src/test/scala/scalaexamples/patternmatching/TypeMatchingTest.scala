package scalaexamples.patternmatching

import junit.framework.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import scalaexamples.EmptyTest

@RunWith(classOf[JUnit4])
class TypeMatchingTest extends EmptyTest {
  
  @Test 
  def matchOnType {
	val elements = List(23, "Hello", 8.5, 'q') 
	for (element <- elements) { 
	  element match { 
      case i:Int => assertEquals(23, i)
      case s:String => assertEquals("Hello", s)
      case f:Double => assertEquals(8.5, f)
      case c:Char => assertEquals('q', c)
	    case other => error("Should match other on type")
	 }
	}
  }

}
