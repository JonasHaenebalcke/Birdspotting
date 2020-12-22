package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.BirdSpecie;

public class AddBirdValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BirdSpecie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BirdSpecie specie = (BirdSpecie) target;
		
		
//		String name = specie.getName();
//		int year = specie.getYearOfDiscovery();
//		String code = specie.getCode();
		
		
	}

}
