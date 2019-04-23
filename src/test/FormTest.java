package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


import org.junit.jupiter.api.Test;

import main.Form;
import main.Forms;

public class FormTest {
	@Test
	public void should_beFormWith4Blocs_for_allForms() {
		Forms forms = new Forms();
		HashMap<String, Form> allforms = forms.getAllForms();
		Set<String> keys = allforms.keySet();
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext()){
			int nbBloc = 0;
		   String key = it.next();
		   Form value = allforms.get(key);
		   char[][] template = value.getTemplate();
		   for(char[] row:template) {
		   		for(char c:row) {
				   if(c!='0')
				   {
					   nbBloc++;
				   }
			   }
		   }
		   assertEquals(4, nbBloc);
			   
		}
	}

}
