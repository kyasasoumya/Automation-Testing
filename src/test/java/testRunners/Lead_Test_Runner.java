package testRunners;
  
  import org.junit.runner.RunWith;
  
  import io.cucumber.junit.Cucumber; import io.cucumber.junit.CucumberOptions;
  
  @RunWith(Cucumber.class)
  
  @CucumberOptions( features={"classpath:features"},
  glue={"classpath:stepDefinitions"}, 
  tags="@CreatingLeads", 
  monochrome=true,
  publish=true, plugin= {"pretty"}
  
  ) public class Lead_Test_Runner {
  
  }
 