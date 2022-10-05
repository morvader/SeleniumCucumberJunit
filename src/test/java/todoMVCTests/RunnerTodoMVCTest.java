package todoMVCTests;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("TodoMVC")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "todoMVCTests")
public class RunnerTodoMVCTest {
}
