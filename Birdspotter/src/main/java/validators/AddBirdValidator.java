package validators;

import java.time.Year;

import org.springframework.validation.Errors;
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
		Integer year = specie.getYearOfDiscovery();

		if (year == null) 
			return;		

		if (year > Year.now().getValue())
			errors.rejectValue("yearOfDiscovery", "InvalidValueFuture.message", "invalid date");
	}

}
