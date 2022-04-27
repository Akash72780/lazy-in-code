package com.dummy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.dummy.Model.Apparel;
import com.dummy.repository.ApparelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ApparelRepositoryTest {
	
	@Autowired
	private ApparelRepository apparelRepository;
	
	@Test
	public void testFindItemType() {
		List<Apparel> listOfBook=apparelRepository.findApparelId("A107");
		
		assertThat(listOfBook.size(), is(greaterThanOrEqualTo(0)));
	}

}
