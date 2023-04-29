package Home;

import org.testng.annotations.Test;

import GenericUtils.BaseClass;

public class Home extends BaseClass{

	@Test
	public void SMPK_TC_3329(){
		
		soft.assertEquals(explore.avatarTitle(),"Devi Durga");
		explore.navigationExplore();	
		explore.Rashifaltoolbar();
		
		if(explore.widget().isDisplayed()) 
			System.out.println("Widget is present");
		else
			System.out.println("widget is not present");
		
		soft.assertEquals(explore.exploreTitle(), "Explore");	
	}
}
