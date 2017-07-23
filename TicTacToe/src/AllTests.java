/**
 * 
 * @author Saliha
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.sam.go.model.test.FieldTest;
import de.sam.go.model.test.GameModelTest;
import de.sam.go.model.test.PlayerTest;
import de.sam.go.model.test.PlaygroundTest;


@RunWith(Suite.class)
@SuiteClasses({ FieldTest.class, PlayerTest.class, PlaygroundTest.class, GameModelTest.class })
public class AllTests {

}
